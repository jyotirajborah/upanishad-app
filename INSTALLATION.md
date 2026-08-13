# Installation and Setup Guide

## Prerequisites

Before you begin, ensure you have the following installed:

1. **Android Studio** (Hedgehog 2023.1.1 or newer recommended)
   - Download from: https://developer.android.com/studio

2. **Java Development Kit (JDK) 17**
   - Android Studio includes JDK
   - Or download from: https://www.oracle.com/java/technologies/downloads/

3. **Android SDK**
   - Will be installed through Android Studio
   - Minimum required: API Level 24 (Android 7.0)
   - Target: API Level 34 (Android 14)

## Step-by-Step Installation

### 1. Setup Android Studio

1. Download and install Android Studio
2. Open Android Studio
3. Complete the setup wizard
4. Install Android SDK components:
   - Go to: Tools → SDK Manager
   - Install SDK Platform 34
   - Install SDK Build-Tools 34.0.0
   - Install Android Emulator

### 2. Configure SDK Path

1. Find your Android SDK location:
   - Windows: Usually `C:\Users\YourName\AppData\Local\Android\Sdk`
   - Mac: Usually `/Users/YourName/Library/Android/sdk`
   - Linux: Usually `/home/YourName/Android/Sdk`

2. Update `local.properties`:
   ```properties
   sdk.dir=YOUR_SDK_PATH_HERE
   ```
   
   Example for Windows:
   ```properties
   sdk.dir=C\:\\Users\\YourName\\AppData\\Local\\Android\\Sdk
   ```

### 3. Open the Project

1. Launch Android Studio
2. Click "Open" (or File → Open)
3. Navigate to the `UpanishadGyanamrit` folder
4. Click "OK"
5. Wait for Gradle sync to complete (may take 5-10 minutes first time)

### 4. Sync Dependencies

If Gradle sync doesn't start automatically:
1. Click "File" → "Sync Project with Gradle Files"
2. Wait for download to complete
3. Check the "Build" panel at bottom for any errors

### 5. Setup Emulator (Virtual Device)

**Option A: Create New Emulator**
1. Click "Tools" → "Device Manager"
2. Click "Create Device"
3. Select a phone model (e.g., Pixel 5)
4. Click "Next"
5. Download a system image (recommend: API 34, x86_64)
6. Click "Next" → "Finish"

**Option B: Use Physical Device**
1. Enable Developer Options on your Android phone:
   - Go to Settings → About Phone
   - Tap "Build Number" 7 times
2. Enable USB Debugging:
   - Settings → Developer Options → USB Debugging
3. Connect phone via USB
4. Accept debugging authorization on phone

### 6. Build and Run

1. Select your device/emulator from dropdown at top
2. Click the green "Run" button (▶️) or press Shift+F10
3. Wait for build to complete
4. App will install and launch automatically

## Command Line Build (Alternative)

If you prefer command line:

### Windows:
```cmd
cd UpanishadGyanamrit
gradlew.bat assembleDebug
```

### Mac/Linux:
```bash
cd UpanishadGyanamrit
chmod +x gradlew
./gradlew assembleDebug
```

The APK will be generated at:
```
app/build/outputs/apk/debug/app-debug.apk
```

## Common Issues and Solutions

### Issue 1: "SDK location not found"
**Solution**: 
- Update `local.properties` with correct SDK path
- Restart Android Studio

### Issue 2: "Gradle sync failed"
**Solution**: 
- Check internet connection
- File → Invalidate Caches → Invalidate and Restart
- Try: File → Sync Project with Gradle Files

### Issue 3: "Build failed: Compilation error"
**Solution**:
- Clean project: Build → Clean Project
- Rebuild: Build → Rebuild Project
- Check if JDK 17 is selected: File → Project Structure → SDK Location

### Issue 4: "Module not specified"
**Solution**:
- Click "app" from configuration dropdown at top
- If not visible: Run → Edit Configurations → Add → Android App

### Issue 5: Emulator won't start
**Solution**:
- Check BIOS virtualization is enabled (VT-x/AMD-V)
- Install Intel HAXM (for Intel processors)
- Try: Tools → AVD Manager → Wipe Data

### Issue 6: "Manifest merger failed"
**Solution**:
- Check AndroidManifest.xml for errors
- Build → Clean Project
- File → Sync Project with Gradle Files

## Verifying Installation

After successful build, you should see:

1. **Home Screen** with:
   - Om symbol (ॐ)
   - "Upanishad Gyanamrit" title
   - Statistics cards
   - Navigation cards

2. **Bottom Navigation** with:
   - Home icon
   - Shloka icon (🕉️)
   - About icon (📜)

3. **Navigation works**:
   - Tap "Principal Upanishads" → Shows list of 13 Upanishads
   - Tap back → Returns to home
   - Tap "Core Teachings" → Shows 5 concepts
   - Tap "Eternal Wisdom" → Shows quote carousel

## Performance Tips

For faster builds:

1. **Enable Gradle Daemon**
   Already enabled in `gradle.properties`:
   ```properties
   org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
   ```

2. **Enable Build Cache**
   Add to `gradle.properties`:
   ```properties
   org.gradle.caching=true
   ```

3. **Use Parallel Execution**
   Add to `gradle.properties`:
   ```properties
   org.gradle.parallel=true
   ```

## Next Steps

Once installed:

1. **Explore the App**: Try all features and screens
2. **Read APP_GUIDE.md**: Understand the architecture
3. **Customize**: Modify colors, add content
4. **Build Release Version**: For distribution
   ```bash
   ./gradlew assembleRelease
   ```

## Building for Production

To create a signed release APK:

1. **Generate Keystore**:
   ```bash
   keytool -genkey -v -keystore upanishad.keystore -alias upanishad -keyalg RSA -keysize 2048 -validity 10000
   ```

2. **Configure in build.gradle.kts**:
   ```kotlin
   signingConfigs {
       create("release") {
           storeFile = file("upanishad.keystore")
           storePassword = "your_password"
           keyAlias = "upanishad"
           keyPassword = "your_password"
       }
   }
   ```

3. **Build Release**:
   ```bash
   ./gradlew assembleRelease
   ```

## Support

For issues or questions:
- Check Android Studio logs: View → Tool Windows → Logcat
- Check Gradle console: View → Tool Windows → Build
- Review error messages carefully
- Clean and rebuild if stuck

## Testing on Different Devices

Recommended test devices:
- Phone (small): Pixel 4 or similar
- Phone (large): Pixel 7 Pro or similar
- Tablet: Pixel Tablet or similar
- Different Android versions: API 24, 30, 34

---

**Ready to Start!**

Once everything is installed, run the app and enjoy exploring the wisdom of the Upanishads!

**ॐ सर्वे भवन्तु सुखिनः**
