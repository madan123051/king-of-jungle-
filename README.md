# 🐾 King of Jungle — Match-3 Animal Adventure

> *Swap, match, and conquer the wild! A fun match-3 puzzle game set in the heart of the jungle.*

![King of Jungle](https://img.shields.io/badge/Game-King%20of%20Jungle-brightgreen?style=for-the-badge)
![Vercel](https://img.shields.io/badge/Deploy-Vercel-black?style=for-the-badge&logo=vercel)
![HTML5](https://img.shields.io/badge/Platform-HTML5-blue?style=for-the-badge&logo=html5)

## 🎮 Play Now

🌐 **Live:** *Deploy on Vercel to get your URL*

## 🦁 About

**King of Jungle** is a match-3 puzzle game featuring wild animals in a lush jungle setting. Swap adjacent animals to create matches of 3 or more, earn points, and progress through 100 increasingly challenging levels across jungle zones!

### 🐾 Animals
| Emoji | Animal | Unlock |
|-------|--------|--------|
| 🐯 | Tiger | Level 1 |
| 🦌 | Deer | Level 1 |
| 🐐 | Goat | Level 1 |
| 🦅 | Eagle | Level 1 |
| 🐍 | Snake | Level 16 |
| 🐒 | Monkey | Level 32 |
| 🐘 | Elephant | Level 48 |
| 🦚 | Peacock | Level 64 |

### 🌍 Jungle Zones
| Zone | Levels | Theme |
|------|--------|-------|
| Zone I | 1–10 | 🌿 Starter Plains |
| Zone II | 11–20 | 🌲 Deep Forest |
| Zone III | 21–30 | 🏔️ Mountain Pass |
| Zone IV | 31–40 | 🌊 River Delta |
| Zone V | 41–50 | 🌋 Volcano Edge |
| Zone VI | 51–60 | ❄️ Frozen Peaks |
| Zone VII | 61–70 | 🏜️ Desert Ruins |
| Zone VIII | 71–80 | 🌙 Shadow Jungle |
| Zone IX | 81–90 | ⭐ Celestial Canopy |
| Zone X | 91–100 | 👑 King's Domain |

## 🧩 Game Mechanics

### Match Engine
- **Simple match-3** — Swap adjacent animals to create a row/column of 3+ same type
- **Single resolve per swap** — No auto-cascade, no chain reactions
- **+10 points per matched cell**
- **Tap or swipe** to play

### Level Progression
| Parameter | Formula |
|-----------|---------|
| **Grid Size** | 5×5 → 6×6 (L20) → 7×7 (L40) → 8×8 (L60) |
| **Animal Types** | 4 → 5 (L16) → 6 (L32) → 7 (L48) → 8 (L64) |
| **Target Score** | `level × 80` |
| **Moves** | `22 - floor(level / 5)` |

### ⚒️ Power-Ups
| Power-Up | Effect |
|----------|--------|
| ⚒️ Hammer | Remove a single animal |
| 💣 Bomb | Blast a 3×3 area |
| ⚡ Lightning | Clear an entire row |
| 🔀 Shuffle | Randomize the board |

### ❤️ Lives System
- **5 lives max** — lose one when you fail a level
- **Auto-regenerate** over time
- Progress saved via localStorage

## 🏗️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Game Engine** | Vanilla HTML5 + CSS3 + JavaScript |
| **State** | localStorage (offline-first) |
| **Hosting** | Vercel |

## 📁 Project Structure

```
candyboom/
├── vercel.json        # Vercel deployment config
├── README.md          # This file
├── .gitignore
└── public/            # Vercel output directory
    ├── index.html     # 🏠 Landing page (King of Jungle theme)
    └── game.html      # 🎮 Main game (match-3 engine)
```

## 🚀 Deploy on Vercel

### Option 1: One-Click
[![Deploy with Vercel](https://vercel.com/button)](https://vercel.com/new/clone?repository-url=https://github.com/madan123051/candyboom)

### Option 2: CLI
```bash
npm i -g vercel
vercel --prod
```

### Option 3: GitHub Integration
1. Go to [vercel.com](https://vercel.com)
2. Import this repo
3. Output Directory: `public`
4. Deploy! 🚀

## 📱 Mobile (Coming Soon)

APK build via Cordova for **Google Play Store** release — stay tuned!

## 📄 License

© 2025 King of Jungle. All rights reserved.

---

*Made with 🐾 in the jungle*
