@echo off
echo.
echo 🙏 Building Upanishad Gyanamrit APK...
echo ==========================================
echo.

REM Check if Java is installed
java -version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ❌ Java is not installed!
    echo.
    echo Please install Java 17:
    echo https://adoptium.net/temurin/releases/?version=17
    echo.
    pause
    exit /b 1
)

echo ✅ Java found!
echo.

REM Download Gradle if not present
if not exist "gradle-8.2-bin.zip" (
    echo 📥 Downloading Gradle...
    powershell -Command "Invoke-WebRequest -Uri 'https://services.gradle.org/distributions/gradle-8.2-bin.zip' -OutFile 'gradle-8.2-bin.zip'"
    
    echo 📦 Extracting Gradle...
    powershell -Command "Expand-Archive -Path 'gradle-8.2-bin.zip' -DestinationPath '.' -Force"
)

echo 🔨 Building APK...
echo This will take 2-3 minutes...
echo.

gradle-8.2\bin\gradle.bat assembleDebug --no-daemon --stacktrace

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ✅ APK built successfully!
    echo.
    echo 📱 Your APK is at:
    echo app\build\outputs\apk\debug\app-debug.apk
    echo.
    echo You can now:
    echo 1. Copy this file to your phone
    echo 2. Open it on your phone
    echo 3. Install the app!
    echo.
) else (
    echo.
    echo ❌ Build failed!
    echo Check the errors above.
    echo.
)

pause
