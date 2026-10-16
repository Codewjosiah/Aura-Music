package com.metrolist.music.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * AURA Design Tokens
 * Minimal, dark, monochromatic identity with Apple-inspired restraint and Liquid Glass depth.
 */
object AuraTokens {
    // Monochromatic Palette
    val PureBlack = Color(0xFF000000)
    val Obsidian = Color(0xFF0A0A0C)
    val DarkCharcoal = Color(0xFF121215)
    val ElevatedSurface = Color(0xFF1A1A1E)
    val CardSurface = Color(0xFF202026)

    // Glass Translucency
    val GlassSurface = Color(0xCC141418)
    val GlassSurfaceLight = Color(0xDDF8F9FA)
    val GlassBorder = Color(0x26FFFFFF)
    val GlassHighlight = Color(0x1AFFFFFF)
    val GlassBorderSubtle = Color(0x14FFFFFF)

    // Reference Accent Colors (Electric Lime & Pastels)
    val ElectricLime = Color(0xFFD2F843)
    val ElectricLimeText = Color(0xFF000000)
    val LilacCard = Color(0xFFC8B2F9)
    val LilacCardText = Color(0xFF161024)
    val PlumButton = Color(0xFF3B235E)
    val CharcoalButton = Color(0xFF1B1B22)
    val CharcoalGlass = Color(0xD917171D)

    // Typography & Accents
    val PlatinumWhite = Color(0xFFF5F5F7)
    val SilverSubtext = Color(0xFFA1A1AA)
    val SlateMuted = Color(0xFF71717A)
    val TitaniumAccent = Color(0xFFFFFFFF)

    // Corner Radii
    val RadiusSmall = 12.dp
    val RadiusMedium = 18.dp
    val RadiusCard = 24.dp
    val RadiusLarge = 28.dp
    val RadiusPill = 999.dp
}

/**
 * AURA Liquid Glass surface modifier
 * Applies translucent dark background, delicate specular border, and rounded clipping.
 */
fun Modifier.auraGlass(
    shape: Shape = RoundedCornerShape(AuraTokens.RadiusMedium),
    backgroundColor: Color = AuraTokens.GlassSurface,
    borderColor: Color = AuraTokens.GlassBorder,
    borderWidth: Dp = 1.dp,
    elevation: Dp = 0.dp,
): Modifier {
    val shadowed = if (elevation > 0.dp) this.shadow(elevation, shape) else this
    return shadowed
        .clip(shape)
        .background(backgroundColor)
        .border(borderWidth, borderColor, shape)
}

/**
 * AURA Capsule / Pill container
 */
fun Modifier.auraPill(
    backgroundColor: Color = AuraTokens.GlassSurface,
    borderColor: Color = AuraTokens.GlassBorder,
): Modifier = auraGlass(
    shape = RoundedCornerShape(AuraTokens.RadiusPill),
    backgroundColor = backgroundColor,
    borderColor = borderColor,
    borderWidth = 1.dp
)

/**
 * AURA Gradient Rim / Subtle Glass Glow
 */
fun Modifier.auraSpecularRim(
    shape: Shape = RoundedCornerShape(AuraTokens.RadiusMedium)
): Modifier = this.border(
    width = 1.dp,
    brush = Brush.verticalGradient(
        colors = listOf(
            Color(0x40FFFFFF),
            Color(0x0DFFFFFF)
        )
    ),
    shape = shape
)
