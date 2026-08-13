# 📱 How to Get the APK on Your Phone

## 🎯 3 Simple Ways

---

## ✨ Method 1: Download from GitHub (Once Uploaded)

**This is the easiest for users!**

### Steps:

1. **Go to the repository** on your phone's browser:
   ```
   https://github.com/jyotirajborah/upanishad-app/releases
   ```

2. **Find the latest release**
   - You'll see "v1.0.0" or similar
   - Click on it

3. **Download the APK**
   - Click on `app-debug.apk` 
   - File will download to your phone

4. **Install**
   - Open the downloaded APK
   - Tap "Install"
   - If blocked, go to Settings → Allow from this source
   - Done! 🎉

---

## 🔧 Method 2: Upload to GitHub Yourself

**You need to upload it first, then users can download**

### Quick Steps:

1. **On your computer, in the UpanishadGyanamrit folder:**

   **Windows:**
   ```cmd
   push-to-github.bat
   ```
   
   **Mac/Linux:**
   ```bash
   chmod +x push-to-github.sh
   ./push-to-github.sh
   ```

2. **Create a release on GitHub:**
   - Go to: https://github.com/jyotirajborah/upanishad-app
   - Click **Releases** → **Create a new release**
   - Tag: `v1.0.0`
   - Title: `Upanishad Gyanamrit v1.0.0`
   - Upload the APK file (get it from Actions or build it)
   - Click **Publish release**

3. **Share the link:**
   ```
   https://github.com/jyotirajborah/upanishad-app/releases/latest
   ```

Now anyone can download the APK directly!

**Detailed instructions in GITHUB_UPLOAD.md**

---

## 🔨 Method 3: Build APK Yourself

**For testing before uploading**

### Steps:

1. **Open Terminal/Command Prompt**

2. **Navigate to project:**
   ```bash
   cd UpanishadGyanamrit
   ```

3. **Build APK:**
   
   **Windows:**
   ```cmd
   gradlew.bat assembleDebug
   ```
   
   **Mac/Linux:**
   ```bash
   chmod +x gradlew
   ./gradlew assembleDebug
   ```

4. **Find the APK:**
   ```
   app/build/outputs/apk/debug/app-debug.apk
   ```

5. **Transfer to phone:**
   - Email it to yourself
   - Upload to Google Drive/Dropbox
   - Copy via USB cable
   - Use any file transfer method

6. **Install on phone:**
   - Open the APK file
   - Tap Install
   - Allow from unknown sources if needed

---

## 🎬 Recommended Flow

### For You (App Developer):

1. ✅ Build the APK (Method 3)
2. ✅ Test it on your phone
3. ✅ Upload to GitHub (Method 2)
4. ✅ Create a Release with the APK
5. ✅ Share the download link

### For Users:

1. ✅ Click your GitHub release link
2. ✅ Download APK
3. ✅ Install
4. ✅ Enjoy! 🙏

---

## 📋 Complete Checklist

**To make APK available for download:**

- [ ] Make sure repository exists: https://github.com/jyotirajborah/upanishad-app
- [ ] Run `push-to-github.bat` (Windows) or `push-to-github.sh` (Mac/Linux)
- [ ] Go to GitHub → Actions → Wait for build to complete
- [ ] Download APK from Actions artifacts OR build locally
- [ ] Go to Releases → Create new release
- [ ] Upload the APK file
- [ ] Publish release
- [ ] Share the release link!

---

## 🔗 Important Links

**Your Repository:**
```
https://github.com/jyotirajborah/upanishad-app
```

**Direct Download (after release):**
```
https://github.com/jyotirajborah/upanishad-app/releases/latest
```

**Create New Repository (if needed):**
```
https://github.com/new
```

**Get Personal Access Token:**
```
https://github.com/settings/tokens
```

---

## ⚙️ Installation Requirements

**For users downloading the APK:**
- Android 7.0 (Nougat) or higher
- ~50 MB storage space
- Allow installation from unknown sources

---

## 🆘 Troubleshooting

### "Can't download from GitHub"
- Make sure you created a Release
- Check the APK is uploaded to the Release
- Try opening link in Chrome/Firefox

### "Can't install APK"
- Go to Settings → Security → Allow unknown sources
- Or Settings → Apps → Special access → Install unknown apps
- Enable for your browser or file manager

### "App not working"
- Check Android version (need 7.0+)
- Try uninstalling and reinstalling
- Clear app cache

---

## 🎯 Summary

**Easiest for you:**
1. Run `push-to-github.bat`
2. Create release on GitHub
3. Upload APK
4. Share link

**Easiest for users:**
1. Click your GitHub release link
2. Download APK
3. Install

That's it! 🙏

---

## 📱 After Installation

Users will see:
- App icon in their app drawer
- Name: "Upanishad Gyanamrit"
- Beautiful dark theme
- All the wisdom of Upanishads!

---

**ॐ सर्वे भवन्तु सुखिनः** 

*May all beings be happy*

**Need more help? Check GITHUB_UPLOAD.md for detailed instructions!** 📚
