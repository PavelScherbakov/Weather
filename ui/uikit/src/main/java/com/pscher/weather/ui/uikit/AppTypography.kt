package com.pscher.weather.ui.uikit

import androidx.compose.material.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
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
    /*val paragraph1: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    ),
    val h1: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    val h3: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Normal,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    val h4: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp,
        letterSpacing = 0.sp
    ),
    val h5: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    val h6: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        letterSpacing = 0.sp
    ),
    val bookItemTitle: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    ),
    val bookItemAuthor: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    ),
    val body1: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.sp,
        lineHeight = 24.sp
    ),
    val body2: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = fontApp,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        letterSpacing = 1.25.sp
    ),*/
    val materialTypography: Typography = Typography(
        body1 = paragraph01
    ),
    /*
    val textMediumBold: TextStyle = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 20.sp,
        fontFamily = fontApp,
    ),*/
)