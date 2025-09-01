package com.example.fiziktedavi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlueDark,
    secondary = SecondaryGreenDark,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = TextColorDark,
    onSecondary = TextColorDark,
    onBackground = TextColorDark,
    onSurface = TextColorDark
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryGreen,
    background = BackgroundLight,
    surface = SurfaceLight,
    onPrimary = TextColorLight,
    onSecondary = TextColorLight,
    onBackground = TextColorLight,
    onSurface = TextColorLight
)

@Composable
fun FizikTedaviTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
