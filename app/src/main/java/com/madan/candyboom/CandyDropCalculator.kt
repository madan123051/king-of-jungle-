package com.madan.candyboom

import kotlin.random.Random

/**
 * Strict drop calculator.
 *
 * Goal: a freshly dropped candy must NEVER form an immediate 3-match
 * (horizontal or vertical). Player should match candies manually.
 *
 * Strategy:
 *  1. Build a candidate list of all colors.
 *  2. Eliminate every color that would form a 3-in-a-row at (x, y),
 *     checking ALL 4 line-of-3 patterns:
 *        - vertical:   (x, y-2)(x, y-1)(x,y)  AND (x, y-1)(x,y)(x, y+1) AND (x,y)(x, y+1)(x, y+2)
 *        - horizontal: (x-2, y)(x-1, y)(x,y)  AND (x-1, y)(x,y)(x+1, y) AND (x,y)(x+1, y)(x+2, y)
 *  3. If list becomes empty, fall back to the rarest available color
 *     (still cannot violate rules) - else random pick from all.
 *  4. Apply inverse-frequency weights so rare colors are preferred,
 *     making manual matches possible.
 */
class CandyDropCalculator(private val random: Random = Random.Default) {

    fun calculateDropColor(x: Int, y: Int, board: GameBoard): CandyColor {
        val blocked = forbiddenColors(x, y, board)
        var candidates = CandyColor.all().filterNot { blocked.contains(it) }.toMutableList()

        // Safety: if every color is blocked (extremely rare), relax horizontal
        // constraint and fall back so we never crash.
        if (candidates.isEmpty()) candidates = CandyColor.all().toMutableList()

        val freq = board.colorFrequencies()
        val total = board.totalCells().coerceAtLeast(1)
        val weights = candidates.map { color ->
            val count = freq[color] ?: 0
            (total.toDouble() / (count + 1)).coerceAtLeast(1.0)
        }
        return weightedPick(candidates, weights)
    }

    /** All colors that would create a 3-in-a-row if placed at (x,y). */
    private fun forbiddenColors(x: Int, y: Int, board: GameBoard): Set<CandyColor> {
        val bad = mutableSetOf<CandyColor>()

        // Horizontal triplets that include (x,y)
        addIfTriple(bad, board.get(x - 2, y)?.color, board.get(x - 1, y)?.color)
        addIfTriple(bad, board.get(x - 1, y)?.color, board.get(x + 1, y)?.color)
        addIfTriple(bad, board.get(x + 1, y)?.color, board.get(x + 2, y)?.color)

        // Vertical triplets that include (x,y)
        addIfTriple(bad, board.get(x, y - 2)?.color, board.get(x, y - 1)?.color)
        addIfTriple(bad, board.get(x, y - 1)?.color, board.get(x, y + 1)?.color)
        addIfTriple(bad, board.get(x, y + 1)?.color, board.get(x, y + 2)?.color)

        return bad
    }

    private fun addIfTriple(bad: MutableSet<CandyColor>, a: CandyColor?, b: CandyColor?) {
        if (a != null && a == b) bad.add(a)
    }

    private fun <T> weightedPick(items: List<T>, weights: List<Double>): T {
        val sum = weights.sum()
        val roll = random.nextDouble() * sum
        var acc = 0.0
        for (i in items.indices) {
            acc += weights[i]
            if (roll <= acc) return items[i]
        }
        return items.last()
    }

    /**
     * Fills every empty cell BOTTOM-UP so neighbours below are already known
     * when computing the constraint. This eliminates the original bug where
     * the top row could not see cells that hadn't been filled yet.
     */
    fun fillEmpty(board: GameBoard) {
        for (y in board.height - 1 downTo 0) {
            for (x in 0 until board.width) {
                if (board.get(x, y)?.isEmpty == true) {
                    board.set(x, y, calculateDropColor(x, y, board))
                }
            }
        }
        // Defensive sweep: if any 3-match somehow exists, reroll those cells.
        validateAndFix(board)
    }

    private fun validateAndFix(board: GameBoard, maxPasses: Int = 6) {
        repeat(maxPasses) {
            val offenders = findMatchedCells(board)
            if (offenders.isEmpty()) return
            offenders.forEach { (x, y) ->
                board.set(x, y, null)
                board.set(x, y, calculateDropColor(x, y, board))
            }
        }
    }

    private fun findMatchedCells(board: GameBoard): List<Pair<Int, Int>> {
        val out = mutableListOf<Pair<Int, Int>>()
        // Horizontal scan
        for (y in 0 until board.height) {
            for (x in 0 until board.width - 2) {
                val c = board.get(x, y)?.color ?: continue
                if (c == board.get(x + 1, y)?.color && c == board.get(x + 2, y)?.color) {
                    out.add(x + 2 to y) // reroll the last one
                }
            }
        }
        // Vertical scan
        for (x in 0 until board.width) {
            for (y in 0 until board.height - 2) {
                val c = board.get(x, y)?.color ?: continue
                if (c == board.get(x, y + 1)?.color && c == board.get(x, y + 2)?.color) {
                    out.add(x to y + 2)
                }
            }
        }
        return out
    }
}
