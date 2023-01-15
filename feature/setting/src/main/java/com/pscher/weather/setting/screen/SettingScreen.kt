package com.pscher.weather.setting.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscher.weather.ui.uikit.AppThemeParam
import com.pscher.weather.ui.uikit.appToolbarHeightDp
import kotlinx.coroutines.CoroutineScope
import timber.log.Timber
import com.pscher.weather.resource.common.R as CommonR

@Composable
fun SettingScreen(
    uiState: SettingUiState,
    onClickBack: () -> Unit,
    onChangeThemeLight: (Boolean) -> Unit,
) {

    LaunchedEffect(Unit) {
        Timber.e("Execute SettingScreen")
    }

    val scope: CoroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.background(color = AppThemeParam.colors.background)
    ) {
        //ActionBar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(appToolbarHeightDp)
                .background(color = AppThemeParam.colors.primary)
        ) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp),
                onClick = onClickBack
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = CommonR.drawable.ic_arrow_back),
                    tint = AppThemeParam.colors.text,
                    contentDescription = "Back",
                )
            }

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Настройки",
                textAlign = TextAlign.Center,
                style = AppThemeParam.typography.header03,
                color = AppThemeParam.colors.text,
            )

            //Пустышка
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp),
                onClick = {},
            ) {
                Box(
                    modifier = Modifier
                        .size(24.dp),
                )
            }
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Тёмная тема:",
                textAlign = TextAlign.End,
                style = AppThemeParam.typography.paragraph01,
                color = AppThemeParam.colors.textSecondary,
            )

            Spacer(modifier = Modifier.width(16.dp))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
            ) {
                Switch(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp),
                    checked = uiState.appThemeDark,
                    onCheckedChange = { onChangeThemeLight(!uiState.appThemeDark) },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = AppThemeParam.colors.primaryLight,
                        checkedTrackColor = AppThemeParam.colors.primaryLight,
                        checkedTrackAlpha = 0.7f,
                        uncheckedThumbColor = AppThemeParam.colors.textHint,
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
fun testSettingScreen() {
    MaterialTheme(
        colors = lightColors(
            background = AppThemeParam.colors.background,
            surface = AppThemeParam.colors.background,
        )
    ) {
        Surface() {
            Column() {
                SettingScreen(
                    uiState = testSettingUiState,
                    onClickBack = {},
                    onChangeThemeLight = {},
                )
            }
        }
    }
}