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

val PrimaryColor = Color(0xFF3949ab)
//val primaryLightColor = Color(0xFF6f74dd)
val primaryDarkColor = Color(0xFF00227b)
val SecondaryColor = Color(0xFF1e88e5)
//val secondaryLightColor = Color(0xFF6ab7ff)
//val secondaryDarkColor = Color(0xFF005cb2)
val primaryTextColor = Color(0xFFffffff)
val secondaryTextColor = Color(0xFFffffff)



//Цвета, используемые в приложении
object AppColors {
    val primary = PrimaryColor
    val primaryReverse = AppBlack

    val primaryDark = primaryDarkColor
    val primaryDarkReverse = primaryDarkColor

    val secondary = SecondaryColor
    val secondaryReverse = SecondaryColor

    val background = AppDark10
    val backgroundReverse = AppBlack

    val backgroundTextField = AppDark10
    val backgroundTextFieldReverse = AppDark10

    val text = AppWhite
    val textReverse = AppWhite

    val textHint = Dark40
    val textHintReverse = Dark40

    val textSecondary = PrimaryColor
    val textSecondaryReverse = PrimaryColor

}

interface ColorPalette {
    val primary: Color
    val primaryDark: Color
    val background: Color
    val backgroundTextField: Color
    val text: Color
    val textSecondary: Color
    val textHint: Color

    val materialColors: Colors
}

fun lightColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primary
    override val background: Color = AppColors.background
    override val backgroundTextField: Color = AppColors.backgroundTextField
    override val text: Color = AppColors.text
    override val textSecondary: Color = AppColors.textSecondary
    override val textHint: Color = AppColors.textHint
    override val primaryDark: Color = AppColors.primaryDark

    override val materialColors: Colors = lightColors(
        primary = AppColors.primary,
        secondary = AppColors.secondary,
        background = AppColors.background,
        surface = AppColors.background,
    )
}

fun darkColorPalette(): ColorPalette = object : ColorPalette {
    override val primary: Color = AppColors.primaryReverse
    override val background: Color = AppColors.backgroundReverse
    override val backgroundTextField: Color = AppColors.backgroundTextFieldReverse
    override val text: Color = AppColors.textReverse
    override val textSecondary: Color = AppColors.textSecondaryReverse
    override val textHint: Color = AppColors.textHintReverse
    override val primaryDark: Color = AppColors.primaryDarkReverse

    override val materialColors: Colors = lightColors(
        primary = AppColors.primaryReverse,
        secondary = AppColors.secondaryReverse,
        background = AppColors.backgroundReverse,
        surface = AppColors.backgroundReverse,
    )
}
