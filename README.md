# Upanishad Gyanamrit - Android App

**उपनिषद् ज्ञानामृत — Nectar of Vedic Wisdom**

An Android application dedicated to exploring the timeless wisdom of the Upanishads — ancient Indian scriptures that illuminate the nature of reality, self, and the cosmos.

## Features

- 📜 **Principal Upanishads**: Explore the 13 Mukhya (principal) Upanishads with detailed descriptions
- 🕉️ **Daily Shloka**: Receive a different Upanishadic verse each day with transliteration and meaning
- ✨ **Core Teachings**: Learn about fundamental concepts like Brahman, Atman, Maya, Karma, and Moksha
- 💫 **Eternal Wisdom**: Browse through powerful quotes and verses from various Upanishads
- 🎨 **Beautiful UI**: Elegant design with traditional Indian color palette (saffron, gold, maroon)

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: Modern Android development with Material Design 3
- **Minimum SDK**: 24 (Android 7.0)
- **Target SDK**: 34 (Android 14)

## Project Structure

```
app/
├── src/main/
│   ├── java/com/upanishad/gyanamrit/
│   │   ├── data/              # Data models and repositories
│   │   │   ├── Upanishad.kt
│   │   │   ├── Teaching.kt
│   │   │   ├── Shloka.kt
│   │   │   └── Quote.kt
│   │   ├── ui/
│   │   │   ├── screens/       # Compose UI screens
│   │   │   │   ├── HomeScreen.kt
│   │   │   │   ├── UpanishadsScreen.kt
│   │   │   │   ├── TeachingsScreen.kt
│   │   │   │   ├── ShlokaScreen.kt
│   │   │   │   └── QuotesScreen.kt
│   │   │   └── theme/         # App theme and styling
│   │   │       ├── Color.kt
│   │   │       ├── Theme.kt
│   │   │       └── Type.kt
│   │   └── MainActivity.kt    # Main entry point
│   └── res/                   # Resources (strings, themes, etc.)
└── build.gradle.kts
```

## Getting Started

### Prerequisites

- Android Studio (Arctic Fox or newer)
- JDK 8 or higher
- Android SDK with API level 34

### Installation

1. Clone the repository or copy the project files
2. Open the project in Android Studio
3. Update `local.properties` with your Android SDK path
4. Sync Gradle files
5. Run the app on an emulator or physical device

### Building the App

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease
```

## Upanishads Included

The app features all 13 principal (Mukhya) Upanishads:

1. Isha Upanishad (ईशोपनिषद्)
2. Kena Upanishad (केनोपनिषद्)
3. Katha Upanishad (कठोपनिषद्)
4. Prashna Upanishad (प्रश्नोपनिषद्)
5. Mundaka Upanishad (मुण्डकोपनिषद्)
6. Mandukya Upanishad (माण्डूक्योपनिषद्)
7. Taittiriya Upanishad (तैत्तिरीयोपनिषद्)
8. Chandogya Upanishad (छान्दोग्योपनिषद्)
9. Brihadaranyaka Upanishad (बृहदारण्यकोपनिषद्)
10. Aitareya Upanishad (ऐतरेयोपनिषद्)
11. Shvetashvatara Upanishad (श्वेताश्वतरोपनिषद्)
12. Kaushitaki Upanishad (कौषीतकिब्राह्मणोपनिषद्)

## Core Teachings

The app explains five fundamental concepts from Upanishadic philosophy:

- **Brahman** (ब्रह्मन्): The ultimate, infinite reality
- **Atman** (आत्मन्): The individual self or soul
- **Maya** (माया): The cosmic illusion
- **Karma** (कर्म): The law of cause and effect
- **Moksha** (मोक्ष): Liberation from the cycle of birth and death

## Design Philosophy

The app uses a color palette inspired by traditional Indian aesthetics:

- **Saffron** (#FF9933): Sacred and spiritual
- **Gold** (#D4A843): Divine wisdom
- **Maroon** (#800020): Depth and tradition
- **Cream** (#FFF8E7): Purity and knowledge
- **Charcoal** (#1A1A2E): Contemplation and focus

## Based On

This Android app is based on the web project: [Upanishad Gyanamrit](https://github.com/jyotirajborah/upanishad-gyanamrit)

## License

This project is created for educational and spiritual purposes.

## Contributing

Contributions are welcome! Feel free to submit issues or pull requests.

---

**ॐ सर्वे भवन्तु सुखिनः** — May all beings be happy
