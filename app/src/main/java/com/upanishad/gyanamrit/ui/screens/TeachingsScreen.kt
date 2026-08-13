package com.upanishad.gyanamrit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.upanishad.gyanamrit.data.Teaching
import com.upanishad.gyanamrit.data.TeachingRepository
import com.upanishad.gyanamrit.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TeachingsScreen(onNavigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "Core Teachings",
                            color = GoldLight
                        )
                        Text(
                            "मूल सिद्धान्त",
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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Foundational Principles",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Cream.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )
            }
            
            items(TeachingRepository.teachings) { teaching ->
                TeachingCard(teaching)
            }
            
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun TeachingCard(teaching: Teaching) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Cream.copy(alpha = 0.03f)
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, Gold.copy(alpha = 0.08f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = Gold.copy(alpha = 0.08f),
                border = androidx.compose.foundation.BorderStroke(1.dp, Gold.copy(alpha = 0.15f)),
                modifier = Modifier.size(72.dp)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = teaching.iconType.icon,
                        contentDescription = teaching.name,
                        tint = Gold,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = teaching.name,
                style = MaterialTheme.typography.titleMedium,
                color = GoldLight
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = teaching.sanskritName,
                fontSize = 14.sp,
                color = Saffron.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = teaching.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Cream.copy(alpha = 0.6f),
                textAlign = TextAlign.Center,
                lineHeight = 20.sp
            )
        }
    }
}
