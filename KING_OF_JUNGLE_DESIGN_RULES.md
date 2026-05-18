# 🦁 King of Jungle — Official Game Design Rules & Blueprint

> ⚠️ **MANDATORY RULE:** Jab bhi game mein koi naya level add kiya jaye ya kisi level ko upgrade kiya jaye, **is document ke rules ko strictly follow karna COMPULSORY hai.** Koi bhi exception allowed nahi hai.

---

## Core Concept

A power-pull **match-3 puzzle adventure** that utilizes a realistic jungle food chain, scaling across **1000+ legendary levels**, where the board complexity and logic evolve as the player advances.

- **Feel:** Candy Crush-style gameplay
- **Theme:** Wildlife facts & real-life animal interactions
- **Grid Size:** Fixed at **6×6 (36 icons)**

---

## 1. Global Level Progression Map (1–1000+ Levels)

Jungle Map layout ke anusar progression ko **5 major zones** mein divide kiya gaya hai:

| Zone | Level Range | Biome / Difficulty | Start Moves | New Icons Unlocked | Key Heavyweight Blocker |
|---|---|---|---|---|---|
| **I. Starter Plains** | 1–100 | Open Grasslands (Easy) | 30 | Tiger, Deer, Goat | Rhino (Rare) |
| **II. Thick Forest** | 101–300 | Dense Jungle (Medium) | 38 | Eagle, Snake, Monkey | Elephant (Intro) |
| **III. River Delta** | 301–600 | Swamps & Wetlands | Variable | Multi-level blockers | Multi-Heavyweight |
| **IV. Mountain Peak** | 601–900 | High Altitude (Hard) | High Variable | Apex Predators (Lion) | Persistent Blockers |
| **V. Secret Sanctuary** | 1000+ | Untouched Paradise | Intense | Exotic Event Animals | Extreme Challenge |

> **Note:**
> - Level 1 ke liye moves = **30**
> - Moves scaling Level 101 se start hogi (38, phir levels ke saath variable)
> - Koi bhi level banate waqt uska zone check karein aur usi zone ke rules lagaayein

---

## 2. Match Shapes & Ability Evolution (Attack Patterns)

Jab match bante hain, logic **natural animal nature** par decide hota hai:

| Match Type | Special Icon | Attack Pattern | Description |
|---|---|---|---|
| **5-in-a-Row** | 🐯 **Fierce Tiger** (Apex) | Color bomb sweep | Clears ALL tiles of ONE prey type from the entire board (e.g., all Deer removed) |
| **L-Shape** | ⚔️ **Cross-Clear Strike** | Horizontal + Vertical lines | Clears full row AND full column from the center intersection point |
| **T-Shape** | 💥 **Triple-Sweep Strike** | Three diverging directions | A three-directional sweep of effect that destroys prey in its path |
| **2×2 Box Match** | 💣 **Expanding Blast Zone** | 2×2 → expands to 6-tile radius | Explodes in a 2×2 area, then expands outward to a 6-tile radius blast |

---

## 3. Jungle Food Web — Food Chain Logic (STRICTLY ENFORCED)

> ⚠️ **Animals sirf wahi destroy karte hain jinhein woh natural world mein hunt kar sakte hain. Yeh rule KABHI break nahi hoga.**

### Predator → Prey Table

| Prey Animal | Can Be Hunted By | Result / Animation |
|---|---|---|
| Deer | Tiger, Lion, Wolf, Eagle | Predator strikes → prey tile breaks, predator stays |
| Goat | Tiger, Wolf, Eagle | Same attack animation |
| Snake | Eagle, Mongoose | Eagle swoops → snake tile removed |
| Monkey | Tiger, Eagle, Python | Chase animation → monkey tile removed |
| Small Fish | Eagle, Crocodile | Eagle dives → fish tile removed |

### Non-Killable Blockers (Heavyweight)

| Blocker | Introduced Zone | Predator Interaction |
|---|---|---|
| 🐘 **Elephant (Hathi)** | Zone II (Level 101+) | ALL predator attacks **have zero effect** — Tiger/Lion bounce off and run away animation plays |
| 🦏 **Rhino (Gaida)** | Zone I Rare, Zone II+ Common | Same as Elephant — acts as a **persistent board obstacle** |

> **Rule:** Heavyweight blockers can only be moved/removed by completing **special objectives** defined per level (e.g., "Guide Elephant to Water"). They CANNOT be destroyed by any predator match.

---

## 4. Board Evolution & Objective Scaling

| Level Range | Grid Complexity | Example Objectives |
|---|---|---|
| **1–50** (Starter Grid) | Simple layout, basic prey only, first predator = Tiger | `Hunt 15 Deer` |
| **51–100** | Slightly complex, first Rhino blocker appears (rare) | `Hunt 20 Deer + 10 Goat` |
| **101–200** | Mixed prey, Eagle + Snake + Monkey unlocked | `Hunt 15 Snake before moves run out` |
| **200–500** (Advanced Grid) | Multiple predators, heavyweight blockers active | `Hunt 15 Deer + Guide Elephant to Water` |
| **501–900** | Persistent blockers, Apex Predators (Lion), high move budget needed | `Clear 3 Elephant blockers + Hunt 20 Monkey` |
| **1000+** (Apex Grid) | Multiple heavyweight blockers, extreme match requirements | `Migrate Herd of 10 Deer during Stampede event` |

---

## 5. Core UI Components (Must Be Present on Every Level)

Yeh UI elements **har level pe consistent** rehne chahiye:

| UI Element | Description |
|---|---|
| **Level Counter** | Current level number, clearly visible |
| **Score Aggregator** | Running score for current level |
| **Moves Budget** | Remaining moves (level-specific value, see Zone table) |
| **Target Value** | How many of each prey/objective remain |
| **Best Score** | Player's personal best for this level |
| **Goal Details Text** | Clear objective statement (e.g., `Hunt all Snakes before moves run out`) |
| **Swipe / Restart UI** | Restart button + swipe-to-navigate controls |

---

## 6. Level Addition Checklist (Follow Before Every New Level)

Har naya level add karne se pehle yeh checklist complete karein:

- [ ] Level ka **Zone** identify kiya (I–V)?
- [ ] Correct **move budget** set kiya zone ke hisab se?
- [ ] Sirf wahi **icons unlock** kiye jo us zone ke liye defined hain?
- [ ] **Food chain logic** follow ho rahi hai (predator sirf natural prey hi kha sakta hai)?
- [ ] **Heavyweight blockers** (Elephant/Rhino) correctly placed hain aur destroyable nahi hain?
- [ ] **Match shape abilities** (5-in-a-row, L, T, 2×2) correctly implemented hain?
- [ ] **Objective** us zone ke difficulty ke hisab se scale ho rahi hai?
- [ ] Saare **UI elements** present aur functional hain?

---

## 7. Golden Rules (NEVER Break These)

1. **Food chain is sacred** — predators cannot eat animals outside their natural diet
2. **Elephants & Rhinos are indestructible** by predator matches — always
3. **Grid is always 6×6** — never change the grid size
4. **Zone rules are strict** — don't introduce Zone III icons in Zone I levels
5. **UI must be complete** on every single level, no exceptions
6. **Difficulty must scale** — each zone must feel harder than the last
7. **Every level must be winnable** — test that objectives can be achieved within the move budget

---

*Last Updated: 2026-05-18 | Version: 1.0*
*Yeh document game ka constitution hai — respect it always. 🌿*
