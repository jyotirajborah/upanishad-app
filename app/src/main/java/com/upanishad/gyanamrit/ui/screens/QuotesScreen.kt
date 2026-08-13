package com.upanishad.gyanamrit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.upanishad.gyanamrit.data.QuoteRepository
import com.upanishad.gyanamrit.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun QuotesScreen(onNavigateBack: () -> Unit) {
    val quotes = QuoteRepository.quotes
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            "Eternal Wisdom",
                            color = GoldLight
                        )
                        Text(
                            "शाश्वत ज्ञान",
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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ॐ",
                    fontSize = 32.sp,
                    color = Gold.copy(alpha = 0.7f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Timeless Quotes",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Cream.copy(alpha = 0.7f)
                )
                
                Divider(
                    modifier = Modifier
                        .width(80.dp)
                        .padding(vertical = 16.dp),
                    thickness = 3.dp,
                    color = Gold
                )
            }
            
            HorizontalPager(
                count = quotes.size,
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { page ->
                QuoteCard(
                    quote = quotes[page]
                )
            }
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            if (pagerState.currentPage > 0) {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    },
                    enabled = pagerState.currentPage > 0
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Previous",
                        tint = if (pagerState.currentPage > 0) Gold else Gold.copy(alpha = 0.3f)
                    )
                }
                
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    activeColor = Gold,
                    inactiveColor = Gold.copy(alpha = 0.3f)
                )
                
                IconButton(
                    onClick = {
                        coroutineScope.launch {
                            if (pagerState.currentPage < quotes.size - 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    },
                    enabled = pagerState.currentPage < quotes.size - 1
                ) {
                    Icon(
                        Icons.Default.ArrowForward,
                        contentDescription = "Next",
                        tint = if (pagerState.currentPage < quotes.size - 1) Gold else Gold.copy(alpha = 0.3f)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}

@Composable
fun QuoteCard(quote: com.upanishad.gyanamrit.data.Quote) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
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
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = """,
                    fontSize = 64.sp,
                    color = Gold.copy(alpha = 0.2f),
                    lineHeight = 0.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .offset(x = (-16).dp, y = 16.dp)
                )
                
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 18.sp,
                    color = Cream,
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = quote.source,
                    fontSize = 14.sp,
                    color = Gold,
                    letterSpacing = 1.5.sp
                )
            }
        }
    }
}
