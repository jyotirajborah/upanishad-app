package com.upanishad.gyanamrit

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.upanishad.gyanamrit.ui.screens.*
import com.upanishad.gyanamrit.ui.theme.*
import kotlinx.coroutines.launch

sealed class Screen(val route: String, val title: String, val sanskritTitle: String) {
    object Home : Screen("home", "Home", "गृह")
    object Upanishads : Screen("upanishads", "Upanishads", "उपनिषद्")
    object Teachings : Screen("teachings", "Teachings", "सिद्धान्त")
    object Shloka : Screen("shloka", "Daily Shloka", "श्लोक")
    object Quotes : Screen("quotes", "Quotes", "उद्धरण")
}

class MainActivity : ComponentActivity() {
    private lateinit var updateChecker: UpdateChecker
    
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            checkForUpdates()
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateChecker = UpdateChecker(this)
        
        setContent {
            UpanishadGyanamritTheme(darkTheme = true) {
                var showUpdateDialog by remember { mutableStateOf(false) }
                var updateInfo by remember { mutableStateOf<UpdateChecker.UpdateInfo?>(null) }
                
                LaunchedEffect(Unit) {
                    // Check for updates on app launch
                    val update = updateChecker.checkForUpdates()
                    if (update != null) {
                        updateInfo = update
                        showUpdateDialog = true
                    }
                }
                
                if (showUpdateDialog && updateInfo != null) {
                    UpdateDialog(
                        updateInfo = updateInfo!!,
                        onDismiss = { showUpdateDialog = false },
                        onUpdate = {
                            requestStoragePermissionAndUpdate(updateInfo!!.downloadUrl)
                            showUpdateDialog = false
                        }
                    )
                }
                
                MainScreen()
            }
        }
    }
    
    private fun requestStoragePermissionAndUpdate(downloadUrl: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Android 13+ doesn't need storage permission for downloads
            updateChecker.downloadAndInstallUpdate(downloadUrl)
        } else {
            when {
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED -> {
                    updateChecker.downloadAndInstallUpdate(downloadUrl)
                }
                else -> {
                    requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                }
            }
        }
    }
    
    private fun checkForUpdates() {
        lifecycleScope.launch {
            val update = updateChecker.checkForUpdates()
            if (update != null) {
                updateChecker.downloadAndInstallUpdate(update.downloadUrl)
            }
        }
    }
}

@Composable
fun UpdateDialog(
    updateInfo: UpdateChecker.UpdateInfo,
    onDismiss: () -> Unit,
    onUpdate: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Update",
                tint = Gold,
                modifier = Modifier.size(48.dp)
            )
        },
        title = {
            Column {
                Text(
                    "Update Available",
                    style = MaterialTheme.typography.titleLarge,
                    color = Gold
                )
                Text(
                    "Version ${updateInfo.version}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Saffron
                )
            }
        },
        text = {
            Text(
                "A new version of Upanishad Gyanamrit is available!\n\n${updateInfo.releaseNotes}",
                style = MaterialTheme.typography.bodyMedium,
                color = Cream.copy(alpha = 0.8f)
            )
        },
        confirmButton = {
            Button(
                onClick = onUpdate,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gold
                )
            ) {
                Text("Update Now", color = Charcoal)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Later", color = Cream.copy(alpha = 0.7f))
            }
        },
        containerColor = Charcoal,
        iconContentColor = Gold
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = Charcoal,
                contentColor = Gold
            ) {
                NavigationBarItem(
                    icon = {
                        Column {
                            androidx.compose.material3.Icon(
                                Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        }
                    },
                    label = { Text("Home") },
                    selected = currentRoute == Screen.Home.route,
                    onClick = { navController.navigate(Screen.Home.route) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Gold,
                        selectedTextColor = Gold,
                        indicatorColor = Gold.copy(alpha = 0.2f),
                        unselectedIconColor = Cream.copy(alpha = 0.5f),
                        unselectedTextColor = Cream.copy(alpha = 0.5f)
                    )
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Face,
                            contentDescription = "Shloka"
                        )
                    },
                    label = { Text("Shloka") },
                    selected = currentRoute == Screen.Shloka.route,
                    onClick = { navController.navigate(Screen.Shloka.route) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Gold,
                        selectedTextColor = Gold,
                        indicatorColor = Gold.copy(alpha = 0.2f),
                        unselectedIconColor = Cream.copy(alpha = 0.5f),
                        unselectedTextColor = Cream.copy(alpha = 0.5f)
                    )
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = "About"
                        )
                    },
                    label = { Text("About") },
                    selected = currentRoute == Screen.Upanishads.route,
                    onClick = { navController.navigate(Screen.Upanishads.route) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Gold,
                        selectedTextColor = Gold,
                        indicatorColor = Gold.copy(alpha = 0.2f),
                        unselectedIconColor = Cream.copy(alpha = 0.5f),
                        unselectedTextColor = Cream.copy(alpha = 0.5f)
                    )
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onNavigateToUpanishads = { navController.navigate(Screen.Upanishads.route) },
                    onNavigateToTeachings = { navController.navigate(Screen.Teachings.route) },
                    onNavigateToQuotes = { navController.navigate(Screen.Quotes.route) }
                )
            }
            composable(Screen.Upanishads.route) {
                UpanishadsScreen(
                    onNavigateBack = { navController.popBackStack() }
                )
            }
            composable(Screen.Teachings.route) {
                TeachingsScreen(
                    onNavigateBack = { navController.popBackStack() }
                )
            }
            composable(Screen.Shloka.route) {
                ShlokaScreen(
                    onNavigateBack = { navController.popBackStack() }
                )
            }
            composable(Screen.Quotes.route) {
                QuotesScreen(
                    onNavigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}
