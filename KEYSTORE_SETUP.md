# Fix Package Conflict - Setup Release Signing

## The Problem
Every GitHub Actions build creates a new debug key → different signature → package conflict

## The Solution
Create ONE release keystore and use it for ALL builds

## Steps to Fix (5 minutes)

### 1. Create Keystore (Run this on your computer)
```bash
# Open PowerShell and run:
cd "C:\Program Files\Android\Android Studio\jbr\bin"
.\keytool -genkey -v -keystore upanishad-release.keystore -alias upanishad -keyalg RSA -keysize 2048 -validity 10000

# It will ask for passwords - use: upanishad2025
# For name/organization: just press Enter for all
```

This creates `upanishad-release.keystore` file

### 2. Convert to Base64
```bash
# In PowerShell:
[Convert]::ToBase64String([IO.File]::ReadAllBytes("upanishad-release.keystore")) | Out-File keystore-base64.txt
```

### 3. Add to GitHub Secrets
1. Go to: https://github.com/jyotirajborah/upanishad-app/settings/secrets/actions
2. Click "New repository secret"
3. Name: `KEYSTORE_BASE64`
4. Value: Paste content from `keystore-base64.txt`
5. Click "Add secret"

### 4. Add Password Secrets
Add two more secrets:
- Name: `KEYSTORE_PASSWORD`, Value: `upanishad2025`
- Name: `KEY_PASSWORD`, Value: `upanishad2025`

### 5. I'll Update the Workflow
Once you've added the secrets, tell me and I'll update the GitHub Actions workflow to use them.

## After This
- ALL builds will have the same signature
- Updates will work perfectly
- No more package conflicts
- No more "harmful app" warnings (properly signed)

---

**Don't have Android Studio?**
Tell me and I'll guide you through installing just the Java tools needed.
