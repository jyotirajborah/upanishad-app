package com.upanishad.gyanamrit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.upanishad.gyanamrit.ui.screens.*
import com.upanishad.gyanamrit.ui.theme.*

sealed class Screen(val route: String, val title: String, val sanskritTitle: String) {
    object Home : Screen("home", "Home", "गृह")
    object Upanishads : Screen("upanishads", "Upanishads", "उपनिषद्")
    object Teachings : Screen("teachings", "Teachings", "सिद्धान्त")
    object Shloka : Screen("shloka", "Daily Shloka", "श्लोक")
    object Quotes : Screen("quotes", "Quotes", "उद्धरण")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UpanishadGyanamritTheme(darkTheme = true) {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    Scaffold(
        bottomBar = {
            if (currentRoute == Screen.Home.route) {
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
                        selected = true,
                        onClick = { },
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
                            Text(
                                text = "🕉️",
                                fontSize = 24.sp
                            )
                        },
                        label = { Text("Shloka") },
                        selected = false,
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
                            Text(
                                text = "📜",
                                fontSize = 24.sp
                            )
                        },
                        label = { Text("About") },
                        selected = false,
                        onClick = { /* TODO: About screen */ },
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
