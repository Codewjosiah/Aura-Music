package com.metrolist.music.ui.component

import java.util.Calendar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.metrolist.music.R
import com.metrolist.music.ui.theme.AuraTokens
import com.metrolist.music.ui.theme.auraGlass

/**
 * AURA Music Home Header
 * Faithfully matches Reference Screen 1 (Image 1 & 3):
 * - Circular avatar with ambient atmospheric color glow
 * - Circular dark glass Search & Favorites buttons
 * - Prominent "Hi, Samantha" greeting in bold white sans-serif
 */
@Composable
fun AuraHomeHeader(
    accountName: String?,
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit,
    onHistoryClick: (() -> Unit)? = null,
    onFavoritesClick: (() -> Unit)? = null,
    onAccountClick: (() -> Unit)? = null,
) {
    val displayName = remember(accountName) {
        if (!accountName.isNullOrBlank()) {
            accountName.trim().split(" ").firstOrNull() ?: "Samantha"
        } else {
            "Samantha"
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Horizontal))
            .padding(horizontal = 20.dp, vertical = 6.dp)
    ) {
        // Top Action Row: Avatar with Atmospheric Glow + Search and Heart Pill Buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // User Avatar with soft atmospheric glow
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clickable(enabled = onAccountClick != null) { onAccountClick?.invoke() }
            ) {
                // Ambient aura radial glow behind avatar
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            brush = androidx.compose.ui.graphics.Brush.radialGradient(
                                colors = listOf(
                                    Color(0x99B855D8),
                                    Color(0x334E2682),
                                    Color.Transparent
                                )
                            ),
                            shape = CircleShape
                        )
                )

                // Avatar disc
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(AuraTokens.CharcoalButton)
                        .border(1.5.dp, AuraTokens.GlassBorder, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.person),
                        contentDescription = "Profile",
                        tint = Color.White.copy(alpha = 0.9f),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            // Top-right actions: Circular Search and Heart buttons
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Search circular glass button
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(AuraTokens.CharcoalButton)
                        .border(1.dp, AuraTokens.GlassBorderSubtle, CircleShape)
                        .clickable(onClick = onSearchClick),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "Search",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Heart / Favorites circular glass button
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(AuraTokens.CharcoalButton)
                        .border(1.dp, AuraTokens.GlassBorderSubtle, CircleShape)
                        .clickable { onFavoritesClick?.invoke() ?: onHistoryClick?.invoke() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(R.drawable.favorite),
                        contentDescription = "Favorites",
                        tint = Color.White,
                        modifier = Modifier.size(19.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // Editorial Greeting: "Hi, Samantha"
        Text(
            text = "Hi, $displayName",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                letterSpacing = (-0.5).sp,
                color = Color.White
            )
        )

        Spacer(modifier = Modifier.height(14.dp))
    }
}
