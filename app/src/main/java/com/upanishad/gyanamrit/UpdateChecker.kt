package com.upanishad.gyanamrit

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Environment
import androidx.core.content.FileProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.net.HttpURLConnection
import java.net.URL

class UpdateChecker(private val context: Context) {
    
    companion object {
        private const val GITHUB_API_URL = "https://api.github.com/repos/jyotirajborah/upanishad-app/releases/latest"
        private const val CURRENT_VERSION = "1.2.0" // Update this with each release
    }
    
    data class UpdateInfo(
        val version: String,
        val downloadUrl: String,
        val releaseNotes: String
    )
    
    suspend fun checkForUpdates(): UpdateInfo? = withContext(Dispatchers.IO) {
        try {
            val url = URL(GITHUB_API_URL)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "GET"
            connection.setRequestProperty("Accept", "application/vnd.github.v3+json")
            connection.connectTimeout = 10000
            connection.readTimeout = 10000
            
            if (connection.responseCode == 200) {
                val response = connection.inputStream.bufferedReader().use { it.readText() }
                parseUpdateInfo(response)
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    
    private fun parseUpdateInfo(json: String): UpdateInfo? {
        return try {
            // Simple JSON parsing (in production, use Gson or kotlinx.serialization)
            val versionRegex = """"tag_name":\s*"v?([^"]+)"""".toRegex()
            val downloadRegex = """"browser_download_url":\s*"([^"]+\.apk)"""".toRegex()
            val notesRegex = """"body":\s*"([^"]+)"""".toRegex()
            
            val version = versionRegex.find(json)?.groupValues?.get(1)
            val downloadUrl = downloadRegex.find(json)?.groupValues?.get(1) 
                ?: "https://github.com/jyotirajborah/upanishad-app/releases/latest/download/app-debug.apk"
            val notes = notesRegex.find(json)?.groupValues?.get(1) ?: "New version available"
            
            if (version != null && version != CURRENT_VERSION) {
                UpdateInfo(version, downloadUrl, notes)
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
    
    fun downloadAndInstallUpdate(downloadUrl: String): Long {
        val request = DownloadManager.Request(Uri.parse(downloadUrl))
            .setTitle("Upanishad Gyanamrit Update")
            .setDescription("Downloading latest version...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "upanishad-gyanamrit-update.apk")
            .setAllowedOverMetered(true)
            .setAllowedOverRoaming(true)
        
        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val downloadId = downloadManager.enqueue(request)
        
        // Register receiver to install APK after download completes
        val onComplete = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val id = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id == downloadId) {
                    installUpdate(context, downloadManager, downloadId)
                    context.unregisterReceiver(this)
                }
            }
        }
        
        context.registerReceiver(
            onComplete,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE),
            Context.RECEIVER_NOT_EXPORTED
        )
        
        return downloadId
    }
    
    private fun installUpdate(context: Context, downloadManager: DownloadManager, downloadId: Long) {
        val uri = downloadManager.getUriForDownloadedFile(downloadId)
        val installIntent = Intent(Intent.ACTION_VIEW).apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val file = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                    "upanishad-gyanamrit-update.apk"
                )
                val apkUri = FileProvider.getUriForFile(
                    context,
                    "${context.packageName}.fileprovider",
                    file
                )
                setDataAndType(apkUri, "application/vnd.android.package-archive")
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            } else {
                setDataAndType(uri, "application/vnd.android.package-archive")
            }
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(installIntent)
    }
}
