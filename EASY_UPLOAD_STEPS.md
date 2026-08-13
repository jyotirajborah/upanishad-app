# 🚀 Upload to GitHub - Super Simple Steps

## ⚡ Just 3 Steps!

---

## Step 1️⃣: Create Repository on GitHub

1. Go to: **https://github.com/new**

2. Fill in:
   - Repository name: `upanishad-app`
   - Description: `Android app for Upanishad Gyanamrit`
   - Make it **Public** ✓
   - **Don't** check any boxes (no README, no .gitignore)

3. Click **Create repository**

---

## Step 2️⃣: Upload the Code

**On your computer, in the UpanishadGyanamrit folder:**

### Windows:
Double-click `push-to-github.bat`

### Mac/Linux:
Open terminal and run:
```bash
chmod +x push-to-github.sh
./push-to-github.sh
```

**That's it!** Your code is now on GitHub! ✅

---

## Step 3️⃣: Create a Release with APK

### Option A: Use GitHub Actions (Automatic)

1. Go to your repository: **https://github.com/jyotirajborah/upanishad-app**
2. Click **Actions** tab
3. Wait 2-3 minutes for build to complete ⏳
4. Click on the completed workflow
5. Scroll down to **Artifacts**
6. Download **upanishad-gyanamrit-debug.zip**
7. Unzip to get `app-debug.apk`

### Option B: Build APK Yourself

In UpanishadGyanamrit folder:

**Windows:**
```cmd
gradlew.bat assembleDebug
```

**Mac/Linux:**
```bash
./gradlew assembleDebug
```

Find APK at: `app/build/outputs/apk/debug/app-debug.apk`

### Now Create the Release:

1. Go to: **https://github.com/jyotirajborah/upanishad-app/releases/new**

2. Fill in:
   - Tag version: `v1.0.0`
   - Release title: `Upanishad Gyanamrit v1.0.0`
   - Description:
     ```
     Download the APK and install on Android!
     
     Features:
     - 13 Principal Upanishads
     - Daily Sanskrit Verses
     - Core Teachings
     - Wisdom Quotes
     
     Requirements: Android 7.0+
     ```

3. **Drag and drop** `app-debug.apk` into the upload box

4. Click **Publish release** 🎉

---

## 🎉 Done! Share This Link:

```
https://github.com/jyotirajborah/upanishad-app/releases/latest
```

Anyone can now:
1. Click that link on their phone
2. Download the APK
3. Install it
4. Use your app! 📱

---

## 📱 Quick Test

**Test it yourself:**
1. Open the link above on your phone
2. Tap the APK file to download
3. Open downloaded file
4. Allow installation from unknown sources
5. Install and enjoy!

---

## 🔄 Future Updates

When you make changes:

1. Make your code changes
2. Run `push-to-github.bat` again
3. Create a new release (v1.1.0, v1.2.0, etc.)
4. Upload new APK

Users will always get the latest from `/releases/latest`

---

## ❓ Need Help?

**Detailed guides available:**
- **GITHUB_UPLOAD.md** - Complete GitHub instructions
- **HOW_TO_GET_APK.md** - All methods to get APK
- **INSTALLATION.md** - Development setup

---

## 🎯 Recap

```
Create repo → Run push-to-github.bat → Create release → Share link
```

**That's literally it!** 🙏

---

**ॐ शान्ति शान्ति शान्तिः**

*Om Peace Peace Peace*
