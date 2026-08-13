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
import com.upanishad.gyanamrit.data.Upanishad
import com.upanishad.gyanamrit.data.UpanishadRepository
import com.upanishad.gyanamrit.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpanishadsScreen(onNavigateBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "Principal Upanishads",
                            color = GoldLight
                        )
                        Text(
                            "मुख्य उपनिषद्",
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
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "The Thirteen Mukhya Upanishads",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Cream.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                )
            }
            
            items(UpanishadRepository.upanishads) { upanishad ->
                UpanishadCard(upanishad)
            }
            
            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Composable
fun UpanishadCard(upanishad: Upanishad) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Cream.copy(alpha = 0.03f)
        ),
        border = androidx.compose.foundation.BorderStroke(1.dp, Gold.copy(alpha = 0.1f))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Icon(
                imageVector = upanishad.iconType.icon,
                contentDescription = upanishad.name,
                tint = Gold,
                modifier = Modifier
                    .size(36.dp)
                    .padding(bottom = 12.dp)
            )
            Text(
                text = upanishad.name,
                style = MaterialTheme.typography.titleMedium,
                color = GoldLight
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = upanishad.sanskritName,
                fontSize = 14.sp,
                color = Saffron.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = upanishad.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Cream.copy(alpha = 0.65f),
                lineHeight = 20.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = Saffron.copy(alpha = 0.1f),
                border = androidx.compose.foundation.BorderStroke(1.dp, Saffron.copy(alpha = 0.25f))
            ) {
                Text(
                    text = upanishad.veda,
                    fontSize = 11.sp,
                    color = Saffron,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}
