# 🚀 How to Upload This App to GitHub

## Step-by-Step Guide

### 1️⃣ Create GitHub Repository

1. Go to: https://github.com/jyotirajborah/upanishad-app
2. If repository doesn't exist, create it:
   - Go to: https://github.com/new
   - Repository name: `upanishad-app`
   - Description: `Android app for Upanishad Gyanamrit - Nectar of Vedic Wisdom`
   - Choose: **Public** (so others can download)
   - **Don't** initialize with README (we already have one)
   - Click **Create repository**

### 2️⃣ Upload Code to GitHub

From your computer terminal (in the UpanishadGyanamrit folder):

```bash
# The repository is already initialized, so just add the remote
git remote add origin https://github.com/jyotirajborah/upanishad-app.git

# Push to GitHub
git branch -M main
git push -u origin main
```

**If it asks for credentials:**
- Username: Your GitHub username
- Password: Use a Personal Access Token (not your password)
  - Get token: https://github.com/settings/tokens
  - Generate new token (classic)
  - Check "repo" scope
  - Copy the token and use as password

### 3️⃣ Enable GitHub Actions (Auto-build APK)

1. Go to your repository on GitHub
2. Click **Actions** tab
3. Enable Actions if prompted
4. The workflow will automatically run and build the APK!

### 4️⃣ Download APK from GitHub Actions

After the workflow runs:

1. Go to **Actions** tab
2. Click on the latest workflow run
3. Scroll down to **Artifacts**
4. Download **upanishad-gyanamrit-debug.zip**
5. Unzip to get `app-debug.apk`

---

## 📦 Alternative: Create a Release with APK

To make it easier for users to download:

### Option A: Manual Release

1. Build the APK locally first:
   ```bash
   cd UpanishadGyanamrit
   ./gradlew assembleDebug
   ```
   APK will be at: `app/build/outputs/apk/debug/app-debug.apk`

2. Go to your GitHub repository
3. Click **Releases** → **Create a new release**
4. Tag version: `v1.0.0`
5. Release title: `Upanishad Gyanamrit v1.0.0`
6. Description:
   ```markdown
   # Upanishad Gyanamrit - Android App v1.0.0
   
   Download the APK and install on your Android device!
   
   ## Features
   - 13 Principal Upanishads
   - Daily Sanskrit Verses
   - Core Teachings
   - Wisdom Quotes
   
   ## Installation
   1. Download the APK file below
   2. Open it on your Android phone
   3. Allow installation from unknown sources if prompted
   4. Install and enjoy!
   
   ## Requirements
   - Android 7.0 or higher
   ```

7. Drag and drop `app-debug.apk` into the upload area
8. Click **Publish release**

Now anyone can:
- Go to your repository
- Click **Releases**
- Download the APK directly!

### Option B: Automated Release (Advanced)

Create `.github/workflows/release.yml`:

```yaml
name: Create Release

on:
  push:
    tags:
      - 'v*'

jobs:
  build:
    runs-on: ubuntu-latest
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK 17
      uses: actions/setup-java@v3
      with:
        java-version: '17'
        distribution: 'temurin'
    
    - name: Build APK
      run: |
        chmod +x gradlew
        ./gradlew assembleDebug
    
    - name: Create Release
      uses: softprops/action-gh-release@v1
      with:
        files: app/build/outputs/apk/debug/app-debug.apk
      env:
        GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
```

Then create a release by pushing a tag:
```bash
git tag v1.0.0
git push origin v1.0.0
```

---

## 📱 Share the Download Link

After creating a release, share this link:

```
https://github.com/jyotirajborah/upanishad-app/releases/latest
```

Or direct APK download:
```
https://github.com/jyotirajborah/upanishad-app/releases/download/v1.0.0/app-debug.apk
```

Users can:
1. Click the link on their phone
2. Download the APK
3. Install directly!

---

## 🎯 What Users Will See

In your repository's README, you can add a download button:

```markdown
# Upanishad Gyanamrit - Android App

[![Download APK](https://img.shields.io/badge/Download-APK-brightgreen?style=for-the-badge&logo=android)](https://github.com/jyotirajborah/upanishad-app/releases/latest)

## 📱 Installation

1. Click the download button above
2. Open the APK on your Android device
3. Allow installation from unknown sources
4. Install and enjoy!
```

---

## ✅ Checklist

- [ ] Create GitHub repository
- [ ] Push code to GitHub
- [ ] Enable GitHub Actions
- [ ] Build APK (automatic or manual)
- [ ] Create a Release
- [ ] Upload APK to Release
- [ ] Share download link
- [ ] Update README with download button

---

## 🆘 Troubleshooting

### "Permission denied" when pushing
- Check you're using the correct GitHub credentials
- Use Personal Access Token instead of password

### "Gradle build failed" in Actions
- The workflow should work automatically
- Check the Actions logs for specific errors

### APK not appearing in releases
- Make sure you uploaded the file before publishing
- Check the file is named correctly (`app-debug.apk`)

---

## 📖 Additional Resources

- Create Personal Access Token: https://github.com/settings/tokens
- GitHub Actions Docs: https://docs.github.com/en/actions
- Creating Releases: https://docs.github.com/en/repositories/releasing-projects-on-github

---

**That's it! Your app is now on GitHub and anyone can download the APK!** 🎉

Users just need to:
1. Go to your repository
2. Click "Releases"
3. Download the APK
4. Install on their phone

**ॐ शान्ति** 🙏
