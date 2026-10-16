package com.metrolist.music.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.metrolist.music.R
import com.metrolist.music.ui.theme.AuraTokens

/**
 * Curated & Trending featured banner
 * Exact 1:1 implementation of Reference Screen 1 (Images 1 & 3):
 * - Section header "Curated & trending"
 * - Pastel Lilac card with "Discover weekly", description, action row, and artist artwork
 * - Secondary Electric Lime card peeking from the right edge
 */
@Composable
fun AuraCuratedSection(
    modifier: Modifier = Modifier,
    onPlayClick: () -> Unit = {},
    onCardClick: () -> Unit = {},
    artworkUrl: String? = null,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        // Section Header
        Text(
            text = "Curated & trending",
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                color = Color.White
            ),
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 6.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Horizontal Row with Primary Lilac Card and Peeking Lime Card
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp)
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Main Featured Card (Pastel Lilac)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(AuraTokens.RadiusCard))
                    .background(AuraTokens.LilacCard)
                    .clickable(onClick = onCardClick)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Left Text & Controls Column
                    Column(
                        modifier = Modifier
                            .weight(1.1f)
                            .fillMaxHeight()
                            .padding(start = 18.dp, top = 16.dp, bottom = 16.dp, end = 4.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Discover weekly",
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 19.sp,
                                    color = Color(0xFF160E29)
                                )
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "The original slow instrumental best playlists.",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontSize = 11.5.sp,
                                    lineHeight = 15.sp,
                                    color = Color(0xFF4A3A68)
                                ),
                                maxLines = 2
                            )
                        }

                        // Action Controls Row: Plum Play Button, Heart, Download, More
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            // Circular Plum Play Button
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(AuraTokens.PlumButton)
                                    .clickable(onClick = onPlayClick),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.play),
                                    contentDescription = "Play",
                                    tint = Color.White,
                                    modifier = Modifier.size(18.dp)
                                )
                            }

                            // Heart Icon
                            Icon(
                                painter = painterResource(R.drawable.favorite_border),
                                contentDescription = "Like",
                                tint = Color(0xFF332052),
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable { }
                            )

                            // Download Icon
                            Icon(
                                painter = painterResource(R.drawable.download),
                                contentDescription = "Download",
                                tint = Color(0xFF332052),
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable { }
                            )

                            // More Options
                            Icon(
                                painter = painterResource(R.drawable.more_horiz),
                                contentDescription = "More",
                                tint = Color(0xFF332052),
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable { }
                            )
                        }
                    }

                    // Right Artwork / Photo Column
                    Box(
                        modifier = Modifier
                            .weight(0.9f)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        if (artworkUrl != null) {
                            AsyncImage(
                                model = artworkUrl,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(topEnd = AuraTokens.RadiusCard, bottomEnd = AuraTokens.RadiusCard))
                            )
                        } else {
                            // Default artistic illustration
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .background(
                                        brush = androidx.compose.ui.graphics.Brush.linearGradient(
                                            colors = listOf(
                                                Color.Transparent,
                                                Color(0x33441B78),
                                                Color(0x66290C50)
                                            )
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.music_note),
                                    contentDescription = null,
                                    tint = Color(0xFF5B3C8E),
                                    modifier = Modifier.size(52.dp)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Peeking Electric Lime Card on the right
            Box(
                modifier = Modifier
                    .width(18.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(topStart = AuraTokens.RadiusCard, bottomStart = AuraTokens.RadiusCard))
                    .background(AuraTokens.ElectricLime)
            )
        }
    }
}
