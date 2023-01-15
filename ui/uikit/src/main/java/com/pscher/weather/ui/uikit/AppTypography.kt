package com.pscher.weather.ui.uikit

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pscher.weather.resource.common.R


val fontApp = FontFamily(
    Font(R.font.helvetica_neue_thin, FontWeight.Thin),
    Font(R.font.helvetica_neue_ultra_light, FontWeight.ExtraLight),
    Font(R.font.helvetica_neue_light, FontWeight.Light),
    Font(R.font.helvetica_neue, FontWeight.Normal),
    Font(R.font.helvetica_neue_medium, FontWeight.Medium),
    Font(R.font.helvetica_neue_bold, FontWeight.Bold),
    Font(R.font.helvetica_neue_condensed_bold, FontWeight.ExtraBold),
    Font(R.font.helvetica_neue_condensed_black, FontWeight.Black),
)

data class AppTypography
internal constructor(
    val header01: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = 32.sp,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start,
    ),
    val header02: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start,
    ),
    val header03: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start,
    ),
    val paragraph01: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start,
    ),
    val paragraph02: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
        textAlign = TextAlign.Start,
    ),
    val materialTypography: Typography = Typography(
        body1 = paragraph01
    ),
)