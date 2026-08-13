# 🚀 How to Release a New Version

## Quick Release Guide

When you want to release a new version of the app, follow these simple steps:

---

## Step 1: Update Version Numbers

### In `UpdateChecker.kt` (line 11):
```kotlin
companion object {
    private const val GITHUB_API_URL = "https://api.github.com/repos/jyotirajborah/upanishad-app/releases/latest"
    private const val CURRENT_VERSION = "1.1.0" // ← Change this!
}
```

### In `app/build.gradle.kts` (lines 10-11):
```kotlin
defaultConfig {
    applicationId = "com.upanishad.gyanamrit"
    minSdk = 24
    targetSdk = 34
    versionCode = 2        // ← Increment this (was 1, now 2, 3, 4...)
    versionName = "1.1.0"  // ← Change this (1.0.0 → 1.1.0 → 1.2.0...)
```

**Version Naming:**
- **Major**: 1.0.0 → 2.0.0 (big changes, breaking changes)
- **Minor**: 1.0.0 → 1.1.0 (new features)
- **Patch**: 1.0.0 → 1.0.1 (bug fixes)

---

## Step 2: Commit Your Changes

```bash
cd UpanishadGyanamrit
git add .
git commit -m "Release v1.1.0: Add new features"
git push
```

---

## Step 3: Create and Push a Tag

```bash
# Create a version tag
git tag v1.1.0

# Push the tag to GitHub
git push origin v1.1.0
```

---

## Step 4: Wait for GitHub Actions (2-3 minutes)

GitHub Actions will automatically:
1. ✅ Build the APK
2. ✅ Create a GitHub Release
3. ✅ Upload the APK to the release
4. ✅ Add release notes

**Check progress:**
https://github.com/jyotirajborah/upanishad-app/actions

---

## Step 5: Done! 🎉

Users will automatically be notified:
- Next time they open the app → Update dialog appears
- Or they can manually check for updates

**Release URL:**
```
https://github.com/jyotirajborah/upanishad-app/releases/latest
```

---

## 📋 Complete Example

Let's say you want to release version **1.2.0** with a new feature:

### 1. Update version numbers:

**UpdateChecker.kt:**
```kotlin
private const val CURRENT_VERSION = "1.2.0"
```

**build.gradle.kts:**
```kotlin
versionCode = 3
versionName = "1.2.0"
```

### 2. Commit:
```bash
git add .
git commit -m "Release v1.2.0: Added meditation timer feature"
git push
```

### 3. Tag:
```bash
git tag v1.2.0
git push origin v1.2.0
```

### 4. Wait 2-3 minutes

### 5. Check release:
https://github.com/jyotirajborah/upanishad-app/releases/tag/v1.2.0

---

## 🎯 What Happens Automatically

When you push a tag (e.g., `v1.2.0`):

1. **GitHub Actions triggers** the build workflow
2. **APK is built** (app-debug.apk)
3. **APK is renamed** to:
   - `upanishad-app-v1.2.0.apk` (versioned)
   - `app-debug.apk` (stable name for auto-update)
4. **GitHub Release is created** with:
   - Tag: v1.2.0
   - Title: Upanishad Gyanamrit v1.2.0
   - Both APK files attached
   - Beautiful release notes
5. **Users get notified** next time they open the app!

---

## 🔧 Troubleshooting

### "Tag already exists"
```bash
# Delete local tag
git tag -d v1.1.0

# Delete remote tag
git push origin :refs/tags/v1.1.0

# Create new tag
git tag v1.1.0
git push origin v1.1.0
```

### "GitHub Actions failed"
- Check logs: https://github.com/jyotirajborah/upanishad-app/actions
- Most common issue: Build errors
- Fix the code and create a new tag (e.g., v1.1.1)

### "Users not getting update notification"
- Check version number in UpdateChecker.kt
- Verify tag was pushed correctly
- Check GitHub Release was created
- Ensure APK is attached to release

---

## 📊 Version History Example

```
v1.0.0 - Initial release
v1.0.1 - Bug fixes
v1.1.0 - Added meditation timer
v1.2.0 - Added bookmarks feature
v2.0.0 - Major UI redesign
```

---

## ⚡ Quick Commands

**Check current version:**
```bash
git describe --tags --abbrev=0
```

**List all tags:**
```bash
git tag -l
```

**Create and push tag in one go:**
```bash
git tag v1.1.0 && git push origin v1.1.0
```

---

## 🎨 Customizing Release Notes

Edit `.github/workflows/build-apk.yml` (lines 38-57) to customize the release description.

---

## ✨ Best Practices

1. **Always test** before tagging
2. **Update version** in all places (UpdateChecker + build.gradle)
3. **Use semantic versioning** (major.minor.patch)
4. **Write clear commit messages**
5. **Don't delete tags** unless absolutely necessary
6. **Keep changelog** of what changed in each version

---

## 📝 Changelog Template

Create `CHANGELOG.md`:

```markdown
# Changelog

## [1.2.0] - 2024-01-15
### Added
- Meditation timer feature
- Bookmark favorite verses

### Fixed
- Fixed crash on Android 14
- Improved loading speed

## [1.1.0] - 2024-01-01
### Added
- Auto-update feature
- Check for updates button

## [1.0.0] - 2023-12-25
### Added
- Initial release
- 13 Principal Upanishads
- Daily Shlokas
```

---

**That's it! Super simple to release new versions!** 🙏

**ॐ शान्ति**
