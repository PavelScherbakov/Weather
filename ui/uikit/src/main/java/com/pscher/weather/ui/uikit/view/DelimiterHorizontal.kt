package com.pscher.weather.ui.uikit.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pscher.weather.ui.uikit.AppThemeParam

@Composable
fun ColumnScope.DelimiterHorizontal(
    modifier: Modifier = Modifier,
    color: Color = AppThemeParam.colors.backgroundDark,
) {
    Box(
        modifier = modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(color)
    )
}