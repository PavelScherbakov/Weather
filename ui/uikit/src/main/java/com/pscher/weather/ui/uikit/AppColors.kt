package com.pscher.weather.ui.uikit

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val AppWhite = Color(0xFFFFFFFF)
val AppBlack = Color(0xFF000000)


//Цвета, используемые в приложении
object AppColors {
    val primaryLight = Color(0xFF6effff)
    val primaryDark = Color(0xFF00b2cc)

    val background = AppWhite
    val backgroundReverse = AppBlack

    val text = Color(0xFF000000)
    val textReverse = Color(0xFFFFFFFF)
}

interface ColorPalette {
    val primary: Color
    val background: Color

    val materialColors: Colors
}

fun lightColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primaryLight
    override val background: Color = AppColors.background

    override val materialColors: Colors = lightColors(
        primary = AppColors.primaryLight,
        surface = AppColors.background,
        onSurface = AppColors.text,
    )
}

fun darkColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primaryDark
    override val background: Color = AppColors.backgroundReverse

    override val materialColors: Colors = lightColors(
        primary = AppColors.primaryDark,
        surface = AppColors.backgroundReverse,
        onSurface = AppColors.textReverse,
    )
}



