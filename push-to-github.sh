#!/bin/bash

# Script to push Upanishad Gyanamrit app to GitHub

echo "🙏 Upanishad Gyanamrit - GitHub Upload Script"
echo "=============================================="
echo ""

# Check if git is initialized
if [ ! -d ".git" ]; then
    echo "❌ Git not initialized. Run: git init"
    exit 1
fi

# Set remote URL
REPO_URL="https://github.com/jyotirajborah/upanishad-app.git"

echo "📝 Setting remote repository..."
git remote remove origin 2>/dev/null
git remote add origin $REPO_URL

echo "🌿 Renaming branch to main..."
git branch -M main

echo "📤 Pushing to GitHub..."
git push -u origin main

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Success! Your app is now on GitHub!"
    echo ""
    echo "📱 Next steps:"
    echo "1. Go to: https://github.com/jyotirajborah/upanishad-app"
    echo "2. Click 'Actions' to see the build"
    echo "3. Click 'Releases' to create a new release"
    echo "4. Upload the APK from Actions artifacts"
    echo ""
    echo "🎉 Users can now download the APK from your repository!"
else
    echo ""
    echo "❌ Push failed. You may need to:"
    echo "1. Create the repository first: https://github.com/new"
    echo "2. Use a Personal Access Token: https://github.com/settings/tokens"
    echo "3. Or check your credentials"
fi

echo ""
echo "ॐ शान्ति 🙏"
