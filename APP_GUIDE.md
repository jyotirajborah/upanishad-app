# Upanishad Gyanamrit - Android App Guide

## 🎯 Overview

This is a complete Android application built with modern Android development practices, featuring:
- **Jetpack Compose** for UI
- **Material Design 3** for styling
- **Navigation Component** for screen navigation
- **Kotlin** as the programming language

## 📱 App Features

### 1. Home Screen
- Hero section with Om symbol (ॐ) and Sanskrit text
- About section explaining the Upanishads
- Statistics cards showing:
  - 108+ Total Upanishads
  - 13 Principal Upanishads
  - 3000+ Years of Wisdom
  - 4 Connected Vedas
- Navigation cards to explore:
  - Principal Upanishads
  - Core Teachings
  - Eternal Wisdom (Quotes)

### 2. Upanishads Screen
- Lists all 13 principal (Mukhya) Upanishads
- Each card shows:
  - Icon emoji
  - English name
  - Sanskrit name (देवनागरी)
  - Description
  - Associated Veda tag

### 3. Teachings Screen
- Explains 5 core philosophical concepts:
  - Brahman (ब्रह्मन्) - Ultimate reality
  - Atman (आत्मन्) - Individual self
  - Maya (माया) - Cosmic illusion
  - Karma (कर्म) - Law of cause and effect
  - Moksha (मोक्ष) - Liberation
- Beautiful card layout with icons

### 4. Daily Shloka Screen
- Displays a different verse each day based on day of year
- Shows:
  - Sanskrit text in Devanagari
  - Transliteration in Roman script
  - English meaning/translation
  - Source (which Upanishad)
- Elegant card design with decorative elements

### 5. Quotes Screen
- Horizontal pager/carousel of 6 profound quotes
- Swipe navigation between quotes
- Beautiful quotation mark design
- Page indicators showing current position
- Arrow buttons for navigation

## 🎨 Design System

### Color Palette
```kotlin
Saffron = #FF9933      // Primary accent, spiritual
Gold = #D4A843         // Divine wisdom
Maroon = #800020       // Traditional depth
Cream = #FFF8E7        // Text on dark
Charcoal = #1A1A2E     // Surface color
DarkBg = #0F0F1A       // Background
```

### Typography
- **Headings**: Serif font family (elegant, traditional)
- **Body**: Serif font family
- **Devanagari**: System Devanagari font for Sanskrit text

### UI Components
- Cards with subtle transparency and gold borders
- Smooth animations and transitions
- Bottom navigation bar on home screen
- Top app bar with back navigation on sub-screens

## 📂 Project Structure

```
UpanishadGyanamrit/
├── app/
│   ├── src/main/
│   │   ├── java/com/upanishad/gyanamrit/
│   │   │   ├── data/
│   │   │   │   ├── Upanishad.kt         # Data model + Repository
│   │   │   │   ├── Teaching.kt          # Data model + Repository
│   │   │   │   ├── Shloka.kt            # Data model + Repository
│   │   │   │   └── Quote.kt             # Data model + Repository
│   │   │   ├── ui/
│   │   │   │   ├── screens/
│   │   │   │   │   ├── HomeScreen.kt
│   │   │   │   │   ├── UpanishadsScreen.kt
│   │   │   │   │   ├── TeachingsScreen.kt
│   │   │   │   │   ├── ShlokaScreen.kt
│   │   │   │   │   └── QuotesScreen.kt
│   │   │   │   └── theme/
│   │   │   │       ├── Color.kt
│   │   │   │       ├── Theme.kt
│   │   │   │       └── Type.kt
│   │   │   └── MainActivity.kt
│   │   ├── res/
│   │   │   ├── values/
│   │   │   │   ├── strings.xml
│   │   │   │   └── themes.xml
│   │   │   └── xml/
│   │   │       ├── backup_rules.xml
│   │   │       └── data_extraction_rules.xml
│   │   └── AndroidManifest.xml
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── local.properties
└── .gitignore
```

## 🚀 How to Build and Run

### Prerequisites
1. **Android Studio** (Arctic Fox or newer)
2. **JDK 8+**
3. **Android SDK** (with API 34)

### Steps

1. **Setup Android SDK Path**
   - Open `local.properties`
   - Update the `sdk.dir` path to your Android SDK location
   - Example: `sdk.dir=C\:\\Users\\YourName\\AppData\\Local\\Android\\Sdk`

2. **Open in Android Studio**
   - File → Open → Select the `UpanishadGyanamrit` folder
   - Wait for Gradle sync to complete

3. **Build the Project**
   - Build → Make Project (or Ctrl+F9)
   - Fix any errors if they appear

4. **Run on Emulator/Device**
   - Create an Android Virtual Device (AVD) or connect a physical device
   - Run → Run 'app' (or Shift+F10)
   - The app will install and launch

### Build from Command Line

```bash
# Navigate to project directory
cd UpanishadGyanamrit

# Windows
gradlew.bat assembleDebug

# Mac/Linux
./gradlew assembleDebug

# APK will be in: app/build/outputs/apk/debug/
```

## 🔧 Customization Guide

### Adding More Upanishads
Edit `app/src/main/java/com/upanishad/gyanamrit/data/Upanishad.kt`:

```kotlin
Upanishad(
    name = "Your Upanishad Name",
    sanskritName = "संस्कृत नाम",
    description = "Description here...",
    veda = "Associated Veda",
    icon = "🕉️"
)
```

### Adding More Shlokas
Edit `app/src/main/java/com/upanishad/gyanamrit/data/Shloka.kt`:

```kotlin
Shloka(
    sanskrit = "Sanskrit text",
    transliteration = "Roman transliteration",
    meaning = "English translation",
    source = "Source Upanishad"
)
```

### Changing Colors
Edit `app/src/main/java/com/upanishad/gyanamrit/ui/theme/Color.kt`:

```kotlin
val Saffron = Color(0xFFYOURCOLOR)
val Gold = Color(0xFFYOURCOLOR)
// etc...
```

## 📱 Screens Navigation Flow

```
Home Screen
├── → Upanishads Screen (all 13 principal Upanishads)
├── → Teachings Screen (5 core concepts)
└── → Quotes Screen (carousel of quotes)

Bottom Navigation (on Home)
├── Home (current)
├── Daily Shloka (dedicated screen)
└── About (placeholder)
```

## 🎯 Key Technologies Used

1. **Jetpack Compose**: Modern declarative UI toolkit
2. **Material Design 3**: Latest Material Design system
3. **Navigation Compose**: Type-safe navigation
4. **Accompanist Pager**: For swipeable quotes carousel
5. **Kotlin Coroutines**: For async operations

## 📝 Data Storage

Currently, all data is stored in-memory using Kotlin objects (repositories). For future enhancement, you could:
- Add Room Database for offline storage
- Implement SharedPreferences for user preferences
- Add Firebase for cloud sync
- Implement search functionality

## 🌟 Future Enhancements

Potential features to add:
- [ ] Audio pronunciation of Sanskrit verses
- [ ] Favorites/bookmarks system
- [ ] Search functionality
- [ ] Dark/Light theme toggle
- [ ] Share verses on social media
- [ ] Daily notification with shloka
- [ ] Reading progress tracking
- [ ] Notes/annotations feature
- [ ] Multiple language support

## 🐛 Troubleshooting

### Gradle Sync Fails
- Check internet connection
- Update Gradle version in `gradle-wrapper.properties`
- Invalidate Caches: File → Invalidate Caches / Restart

### Build Errors
- Clean project: Build → Clean Project
- Rebuild: Build → Rebuild Project
- Check SDK paths in local.properties

### App Crashes
- Check Logcat for error messages
- Verify minimum SDK version (24) on device
- Check permissions in AndroidManifest.xml

## 📄 License

This project is created for educational and spiritual purposes. Based on the web version by jyotirajborah.

---

**ॐ शान्ति शान्ति शान्तिः**

*Om Shanti Shanti Shantih*

May there be peace, peace, perfect peace.
