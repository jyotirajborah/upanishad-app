# 🚀 Quick Start Guide

## Get Your App Running in 5 Minutes!

### Step 1: Install Android Studio (2 minutes)
1. Download: https://developer.android.com/studio
2. Run installer
3. Follow setup wizard
4. Install Android SDK when prompted

### Step 2: Open the Project (1 minute)
1. Launch Android Studio
2. Click **"Open"**
3. Select the **`UpanishadGyanamrit`** folder
4. Click **"OK"**

### Step 3: Configure SDK Path (30 seconds)
1. Open `local.properties` file
2. Update the `sdk.dir` line:
   
   **Windows:**
   ```properties
   sdk.dir=C\:\\Users\\YourName\\AppData\\Local\\Android\\Sdk
   ```
   
   **Mac:**
   ```properties
   sdk.dir=/Users/YourName/Library/Android/sdk
   ```
   
   **Linux:**
   ```properties
   sdk.dir=/home/YourName/Android/Sdk
   ```

### Step 4: Wait for Gradle Sync (1-2 minutes)
- Android Studio will automatically sync
- Watch the progress bar at bottom
- Wait until it says "BUILD SUCCESSFUL"

### Step 5: Run the App! (30 seconds)
1. Click the green **Run** button ▶️ (or press **Shift+F10**)
2. Select a device (create emulator if needed)
3. Wait for app to build and install
4. **Your app is now running!** 🎉

---

## 📱 What You'll See

### Home Screen
- Beautiful **ॐ** symbol at top
- **"उपनिषद् ज्ञानामृत"** in Devanagari
- Statistics cards showing:
  - 108+ Upanishads
  - 13 Principal ones
  - 3000+ years of wisdom
  - 4 connected Vedas
- Three navigation cards to explore

### Try These Features
1. **Tap "Principal Upanishads"** → See all 13 main Upanishads
2. **Tap "Core Teachings"** → Learn 5 key concepts
3. **Tap "Eternal Wisdom"** → Swipe through quotes
4. **Bottom nav: Tap 🕉️** → See daily Sanskrit verse

---

## 🆘 Quick Troubleshooting

### Problem: "SDK location not found"
**Fix:** Update the `sdk.dir` path in `local.properties`

### Problem: Gradle sync fails
**Fix:** 
- Check internet connection
- File → Invalidate Caches → Restart

### Problem: No emulator
**Fix:**
- Tools → Device Manager → Create Device
- Choose Pixel 5, API 34

### Problem: Build errors
**Fix:**
- Build → Clean Project
- Build → Rebuild Project

---

## 🎯 Next Steps

Once the app is running:

1. **Explore all screens** - Try every feature
2. **Read APP_GUIDE.md** - Understand the code
3. **Customize colors** - Edit `Color.kt`
4. **Add more content** - Edit data repositories
5. **Build your own features** - Expand the app!

---

## 📚 Documentation

- **README.md** - Project overview
- **INSTALLATION.md** - Detailed setup guide
- **APP_GUIDE.md** - Architecture & customization
- **PROJECT_SUMMARY.md** - Complete project info

---

## ✨ That's It!

You now have a fully functional Android app exploring the wisdom of the Upanishads!

### Enjoy! 🙏

**ॐ शान्ति शान्ति शान्तिः**

---

## 🆘 Need More Help?

If you get stuck:
1. Check **INSTALLATION.md** for detailed steps
2. Look at **APP_GUIDE.md** for technical details
3. Review error messages in Logcat
4. Try Clean Project and Rebuild

The app is complete and ready to run - you've got this! 💪
