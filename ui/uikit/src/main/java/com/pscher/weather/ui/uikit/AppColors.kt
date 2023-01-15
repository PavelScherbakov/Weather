package com.pscher.weather.ui.uikit

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val AppWhite = Color(0xFFFFFFFF)
val AppBlack = Color(0xFF000000)

val Dark05 = Color(0xFFF4F4F4)
val AppDark10 = Color(0xFFE9E9EA)
val AppDark20 = Color(0xFFD2D3D5)
val Dark40 = Color(0xFFA5A8AB)
val Dark50 = Color(0xFF8F9296)
val Dark90 = Color(0xFF353B42)

val MainBackground = Color(0xFFF3F5F6)


//Цвета, используемые в приложении
object AppColors {
    val primaryLight = Color(0xFF6effff)
    val primaryDark = Color(0xFF00b2cc)

    val background = AppWhite
    val backgroundReverse = AppBlack

    val backgroundTextField = AppDark10
    val backgroundTextFieldReverse = AppDark10

    val text = Color(0xFF000000)
    val textReverse = Color(0xFFFFFFFF)

    val textSecondary = Dark50
    val textSecondaryReverse = Dark50


}

interface ColorPalette {
    val primary: Color
    val background: Color
    val backgroundTextField: Color
    val text: Color
    val textSecondary: Color

    val materialColors: Colors
}

fun lightColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primaryLight
    override val background: Color = AppColors.background
    override val backgroundTextField: Color = AppColors.backgroundTextField
    override val text: Color = AppColors.text
    override val textSecondary: Color = AppColors.textSecondary

    override val materialColors: Colors = lightColors(
        primary = AppColors.primaryLight,
        surface = AppColors.background,
        onSurface = AppColors.text,
    )
}

fun darkColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primaryDark
    override val background: Color = AppColors.backgroundReverse
    override val backgroundTextField: Color = AppColors.backgroundTextFieldReverse
    override val text: Color = AppColors.textReverse
    override val textSecondary: Color = AppColors.textSecondaryReverse

    override val materialColors: Colors = lightColors(
        primary = AppColors.primaryDark,
        surface = AppColors.backgroundReverse,
        onSurface = AppColors.textReverse,
    )
}



