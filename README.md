# 🐾 King of Jungle — Match-3 Animal Adventure

> *Swap, match, and conquer the wild! A fun match-3 puzzle game set in the heart of the jungle.*

![King of Jungle](https://img.shields.io/badge/Game-King%20of%20Jungle-brightgreen?style=for-the-badge&logo=firebase)
![Firebase](https://img.shields.io/badge/Backend-Firebase-orange?style=for-the-badge&logo=firebase)
![HTML5](https://img.shields.io/badge/Platform-HTML5-blue?style=for-the-badge&logo=html5)

## 🎮 Play Now

🌐 **Live:** [https://king-of-jungle-77f06.web.app](https://king-of-jungle-77f06.web.app)

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
- Lives persist via Firebase

## 🔐 Authentication

- **Google Sign-In** — One-tap login with Google account
- **Guest Mode** — Play anonymously, progress saved locally

## 🏗️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Game Engine** | Vanilla HTML5 + CSS3 + JavaScript |
| **Backend** | Firebase (Auth, Firestore, Hosting) |
| **Auth** | Firebase Authentication (Google + Anonymous) |
| **Database** | Cloud Firestore |
| **Hosting** | Firebase Hosting |
| **Cloud Functions** | Firebase Cloud Functions (Node.js) |

## 📁 Project Structure

```
candyboom/
├── firebase.json              # Firebase Hosting config
├── firestore.rules            # Firestore security rules
├── firestore.indexes.json     # Firestore indexes
├── functions/                 # Cloud Functions
│   ├── package.json
│   └── src/
│       └── index.js           # 6 cloud functions
└── public/                    # Firebase Hosting root
    ├── index.html             # 🏠 Landing page (King of Jungle theme)
    └── game.html              # 🎮 Main game (match-3 engine)
```

## 🚀 Deployment

### Firebase Hosting
```bash
firebase deploy --only hosting
```
Live at: `https://king-of-jungle-77f06.web.app`

### Cloud Functions
```bash
cd functions && npm install
firebase deploy --only functions
```

## 📱 Mobile (Coming Soon)

APK build via Cordova for **Google Play Store** release — stay tuned!

## 📄 License

© 2025 King of Jungle. All rights reserved.

---

*Made with 🐾 in the jungle*
