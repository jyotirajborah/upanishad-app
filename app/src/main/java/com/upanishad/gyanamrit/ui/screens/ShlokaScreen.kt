package com.upanishad.gyanamrit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.upanishad.gyanamrit.data.ShlokaRepository
import com.upanishad.gyanamrit.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShlokaScreen(onNavigateBack: () -> Unit) {
    val shloka = ShlokaRepository.getDailyShloka()
    val scrollState = rememberScrollState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "Daily Shloka",
                            color = GoldLight
                        )
                        Text(
                            "प्रतिदिन श्लोक",
                            fontSize = 12.sp,
                            color = Saffron.copy(alpha = 0.8f)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Gold
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Charcoal,
                    titleContentColor = GoldLight
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .verticalScroll(scrollState)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(
                text = "ॐ",
                fontSize = 48.sp,
                color = Gold.copy(alpha = 0.7f),
                modifier = Modifier.padding(top = 24.dp)
            )
            
            Text(
                text = "A Verse for Today",
                style = MaterialTheme.typography.titleLarge,
                color = GoldLight
            )
            
            Divider(
                modifier = Modifier
                    .width(80.dp)
                    .padding(vertical = 8.dp),
                thickness = 3.dp,
                color = Gold
            )
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Gold.copy(alpha = 0.04f)
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, Gold.copy(alpha = 0.1f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "॥",
                        fontSize = 24.sp,
                        color = Gold.copy(alpha = 0.3f)
                    )
                    
                    Text(
                        text = shloka.sanskrit,
                        fontSize = 20.sp,
                        color = GoldLight,
                        textAlign = TextAlign.Center,
                        lineHeight = 32.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.SemiBold
                    )
                    
                    Text(
                        text = "॥",
                        fontSize = 24.sp,
                        color = Gold.copy(alpha = 0.3f)
                    )
                }
            }
            
            Text(
                text = shloka.transliteration,
                style = MaterialTheme.typography.bodyLarge,
                color = Saffron.copy(alpha = 0.85f),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = shloka.meaning,
                style = MaterialTheme.typography.bodyLarge,
                color = Cream.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                lineHeight = 26.sp
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = shloka.source,
                fontSize = 14.sp,
                color = Gold.copy(alpha = 0.7f),
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}
