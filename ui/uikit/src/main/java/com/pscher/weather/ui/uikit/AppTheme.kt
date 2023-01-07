package com.pscher.weather.ui.uikit

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    typography: AppTypography = AppTypography(),
    content: @Composable () -> Unit,
) {
    val colors = if (isDarkTheme) darkColorPalette() else lightColorPalette()
    CompositionLocalProvider(
        LocalColor provides colors,
    ) {
        MaterialTheme(
            colors = colors.materialColors,
            typography = typography.materialTypography,

        ) {
            content()
        }
    }
}

object AppThemeParam {
    val colors: ColorPalette
        @Composable get() = LocalColor.current

    val typography: AppTypography
        @Composable get() = LocalTypography.current
}

internal val LocalColor = staticCompositionLocalOf { lightColorPalette() }
internal val LocalTypography = staticCompositionLocalOf { AppTypography() }