package com.upanishad.gyanamrit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.upanishad.gyanamrit.UpdateChecker
import com.upanishad.gyanamrit.data.ShlokaRepository
import com.upanishad.gyanamrit.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    onNavigateToUpanishads: () -> Unit,
    onNavigateToTeachings: () -> Unit,
    onNavigateToQuotes: () -> Unit
) {
    val scrollState = rememberScrollState()
    val context = androidx.compose.ui.platform.LocalContext.current
    var showUpdateCheck by remember { mutableStateOf(false) }
    var isCheckingUpdate by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(scrollState)
            .padding(bottom = 80.dp)
    ) {
        // Hero Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(
                            Charcoal,
                            DarkBg
                        )
                    )
                )
                .padding(vertical = 60.dp, horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "ॐ",
                    fontSize = 64.sp,
                    color = Gold,
                    style = MaterialTheme.typography.displayLarge
                )
                Text(
                    text = "उपनिषद् ज्ञानामृत",
                    fontSize = 32.sp,
                    color = GoldLight,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = "Upanishad Gyanamrit",
                    fontSize = 18.sp,
                    color = Saffron,
                    letterSpacing = 4.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "\"असतो मा सद्गमय, तमसो मा ज्योतिर्गमय\"",
                    fontSize = 16.sp,
                    color = Cream.copy(alpha = 0.8f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Lead me from the unreal to the real,\nfrom darkness to light",
                    fontSize = 14.sp,
                    color = Cream.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // About Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "ॐ",
                fontSize = 24.sp,
                color = Gold.copy(alpha = 0.7f)
            )
            Text(
                text = "The Upanishads",
                style = MaterialTheme.typography.displayMedium,
                color = GoldLight
            )
            Text(
                text = "उपनिषद् — \"sitting near\" the truth",
                fontSize = 16.sp,
                color = Saffron.copy(alpha = 0.85f)
            )
            
            Divider(
                modifier = Modifier
                    .width(80.dp)
                    .padding(vertical = 8.dp),
                thickness = 3.dp,
                color = Gold
            )
            
            Text(
                text = "The Upanishads are among humanity's oldest and most profound philosophical texts, forming the spiritual heart of the Vedas.",
                style = MaterialTheme.typography.bodyLarge,
                color = Cream.copy(alpha = 0.7f),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Stats Cards
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatCard("108+", "Total\nUpanishads", Modifier.weight(1f))
            StatCard("13", "Principal\n(Mukhya)", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            StatCard("3000+", "Years of\nWisdom", Modifier.weight(1f))
            StatCard("4", "Vedas\nConnected", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Navigation Cards
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            NavigationCard(
                title = "Principal Upanishads",
                description = "Explore the 13 Mukhya Upanishads",
                icon = Icons.Default.MenuBook,
                onClick = onNavigateToUpanishads
            )
            NavigationCard(
                title = "Core Teachings",
                description = "Learn about Brahman, Atman, and more",
                icon = Icons.Default.Star,
                onClick = onNavigateToTeachings
            )
            NavigationCard(
                title = "Eternal Wisdom",
                description = "Read timeless quotes and verses",
                icon = Icons.Default.Edit,
                onClick = onNavigateToQuotes
            )
            
            // Check for Updates Card
            Card(
                onClick = {
                    if (!isCheckingUpdate) {
                        isCheckingUpdate = true
                        coroutineScope.launch {
                            val updateChecker = UpdateChecker(context)
                            val update = updateChecker.checkForUpdates()
                            if (update != null) {
                                updateChecker.downloadAndInstallUpdate(update.downloadUrl)
                            } else {
                                showUpdateCheck = true
                            }
                            isCheckingUpdate = false
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Gold.copy(alpha = 0.08f)
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, Gold.copy(alpha = 0.3f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = if (isCheckingUpdate) Icons.Default.Refresh else Icons.Default.Refresh,
                        contentDescription = "Update",
                        tint = Gold,
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 16.dp)
                    )
                    Column {
                        Text(
                            text = if (isCheckingUpdate) "Checking..." else "Check for Updates",
                            style = MaterialTheme.typography.titleMedium,
                            color = GoldLight
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Get the latest features and content",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Cream.copy(alpha = 0.65f)
                        )
                    }
                }
            }
        }
    }
    
    if (showUpdateCheck) {
        AlertDialog(
            onDismissRequest = { showUpdateCheck = false },
            title = { 
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Gold,
                        modifier = Modifier.size(24.dp).padding(end = 8.dp)
                    )
                    Text("You're Up to Date", color = Gold)
                }
            },
            text = { Text("You have the latest version installed.", color = Cream.copy(alpha = 0.8f)) },
            confirmButton = {
                TextButton(onClick = { showUpdateCheck = false }) {
                    Text("OK", color = Gold)
                }
            },
            containerColor = Charcoal
        )
    }
}

@Composable
fun StatCard(number: String, label: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.height(120.dp),
        colors = CardDefaults.cardColors(
            containerColor = Cream.copy(alpha = 0.04f)
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, Gold.copy(alpha = 0.12f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = number,
                fontSize = 32.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = Gold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label,
                fontSize = 12.sp,
                color = Cream.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )
        }
    }
}

@Composable
fun NavigationCard(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Cream.copy(alpha = 0.03f)
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, Gold.copy(alpha = 0.1f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = Gold,
                modifier = Modifier
                    .size(36.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = GoldLight
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Cream.copy(alpha = 0.65f)
                )
            }
        }
    }
}
