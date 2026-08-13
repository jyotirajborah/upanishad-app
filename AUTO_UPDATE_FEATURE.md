# 🔄 Auto-Update Feature

## ✨ What's New

Your Upanishad Gyanamrit app now has an **automatic update system**! Users no longer need to manually download and reinstall the app for every update.

---

## 🎯 Features

### 1. **Automatic Update Check on Launch**
- App checks for updates every time it starts
- If a new version is available, shows a beautiful update dialog
- Non-intrusive - users can dismiss and update later

### 2. **Manual Update Check**
- New "Check for Updates" card on the home screen
- Users can manually check anytime
- Shows "You're up to date" message if already on latest version

### 3. **One-Tap Update**
- Click "Update Now" button
- App automatically downloads the latest APK
- Shows download progress notification
- Auto-prompts to install when download completes

### 4. **Smart Permissions**
- Handles Android 13+ (no storage permission needed)
- Requests necessary permissions on older Android versions
- Secure FileProvider implementation

---

## 🎬 How It Works

### For Users:

1. **On App Launch:**
   - App silently checks GitHub for new releases
   - If update available → Shows dialog with version and release notes
   - User clicks "Update Now" → Download starts

2. **Manual Check:**
   - Go to Home screen
   - Scroll down to "Check for Updates" card
   - Tap it → App checks for updates
   - If available → Download starts
   - If up-to-date → Shows confirmation

3. **Installation:**
   - Download completes → Notification appears
   - Tap notification or wait → Install prompt opens
   - Tap "Install" → App updates!
   - Done! 🎉

### For Developers:

**When you release a new version:**

1. **Update version in code:**
   ```kotlin
   // In UpdateChecker.kt
   private const val CURRENT_VERSION = "1.1.0" // Update this!
   ```

2. **Build new APK:**
   ```bash
   ./gradlew assembleDebug
   ```

3. **Create GitHub Release:**
   - Go to: https://github.com/jyotirajborah/upanishad-app/releases/new
   - Tag: `v1.1.0`
   - Title: `Upanishad Gyanamrit v1.1.0`
   - Upload the APK
   - Publish!

4. **Users get auto-notified:**
   - Next time they open the app → Update dialog appears!
   - Or they can manually check for updates

---

## 📋 Technical Details

### Files Added:

1. **UpdateChecker.kt**
   - Checks GitHub API for latest release
   - Compares with current version
   - Downloads and installs updates
   - Handles permissions and notifications

2. **file_paths.xml**
   - FileProvider configuration
   - Allows secure APK file access

3. **Updated MainActivity.kt**
   - Integrates update checker
   - Shows update dialog on launch
   - Handles permissions

4. **Updated HomeScreen.kt**
   - Adds "Check for Updates" button
   - Manual update checking UI

### Permissions Added:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.REQUEST_INSTALL_PACKAGES" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" 
    android:maxSdkVersion="32" />
```

### How Version Check Works:

1. App makes API call to:
   ```
   https://api.github.com/repos/jyotirajborah/upanishad-app/releases/latest
   ```

2. Parses JSON response to get:
   - Latest version tag (e.g., "v1.0.0")
   - Download URL for APK
   - Release notes

3. Compares with `CURRENT_VERSION` constant

4. If newer version exists → Shows update dialog

---

## 🎨 UI Components

### Update Dialog:
- **Title**: "🎉 Update Available"
- **Version**: Shows new version number
- **Description**: Release notes from GitHub
- **Buttons**:
  - "Update Now" - Downloads and installs
  - "Later" - Dismisses dialog

### Check for Updates Card:
- **Icon**: 🔄 (or ⏳ while checking)
- **Title**: "Check for Updates"
- **Description**: "Get the latest features and content"
- **Action**: Tapping checks for updates

---

## ⚙️ Configuration

### To Change Update Source:

Edit `UpdateChecker.kt`:

```kotlin
companion object {
    private const val GITHUB_API_URL = "YOUR_GITHUB_REPO_API_URL"
    private const val CURRENT_VERSION = "1.0.0" // Update with each release
}
```

### To Disable Auto-Check on Launch:

In `MainActivity.kt`, remove:

```kotlin
LaunchedEffect(Unit) {
    val update = updateChecker.checkForUpdates()
    // ...
}
```

---

## 🔒 Security

- ✅ Uses HTTPS for all API calls
- ✅ Downloads only from verified GitHub releases
- ✅ FileProvider for secure APK access
- ✅ No sensitive data transmitted
- ✅ Standard Android install process

---

## 📱 User Experience

### Benefits:
- ✅ No need to visit website for updates
- ✅ One-tap update process
- ✅ Always get latest features
- ✅ Seamless user experience
- ✅ Download progress visible
- ✅ Can update anytime manually

### Considerations:
- Requires internet connection
- Downloads ~8-10 MB per update
- User must allow app installation
- Works on Android 7.0+

---

## 🚀 Release Workflow

### Complete Release Process:

1. **Make your changes** to the app code

2. **Update version number** in:
   - `UpdateChecker.kt` → `CURRENT_VERSION`
   - `build.gradle.kts` → `versionCode` and `versionName`

3. **Build APK**:
   ```bash
   cd UpanishadGyanamrit
   ./gradlew assembleDebug
   ```

4. **Create GitHub Release**:
   - Tag: `v1.x.x`
   - Title: Version name
   - Description: What's new
   - Upload APK file

5. **Done!** Users will automatically be notified!

---

## 🆘 Troubleshooting

### "Update check fails"
- Check internet connection
- Verify GitHub API URL is correct
- Check if GitHub release exists

### "Download doesn't start"
- Check storage permissions
- Verify download URL in GitHub release
- Check device storage space

### "Install doesn't work"
- Enable "Install from unknown sources"
- Check if APK file was downloaded
- Try manual install from Downloads folder

---

## ✨ Future Enhancements

Possible improvements:
- [ ] Show changelog in update dialog
- [ ] Download size indicator
- [ ] Pause/resume downloads
- [ ] Delta updates (only changed files)
- [ ] Background update downloads
- [ ] Update schedule (check weekly)
- [ ] Rollback to previous version

---

## 📊 Summary

**Before:**
- Users had to manually check website
- Download APK from website
- Uninstall old version
- Install new version
- Tedious process

**After:**
- App notifies when update available
- One tap to update
- Automatic download and install
- Much better user experience! 🎉

---

**ॐ शान्ति** - Now your app can update itself! 🙏
