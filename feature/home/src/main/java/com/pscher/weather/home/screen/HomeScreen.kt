package com.pscher.weather.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.pscher.weather.homeapi.HomeNavigationActions
import com.pscher.weather.ui.uikit.AppWhite
import kotlinx.coroutines.delay
import timber.log.Timber

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    updateForecast: suspend () -> Unit,
    onClickFavourite: () -> Unit,
) {
    LaunchedEffect(Unit) {
        Timber.e("Execute HomeScreen (first)")
    }

    //Запускаем периодическое обновление прогноза погоды когда приложение открыто
    val localLifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(Unit) {
        localLifecycleOwner.lifecycleScope.launchWhenResumed {
            while (true) {
                updateForecast()
                delay(300000L)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
        ) {
            Text(
                text = uiState.title,
            )
            Text(
                text = uiState.temperature,
            )
        }

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            onClick = onClickFavourite
        ) {
            Text(text = "Go to FavouriteLocationScreen")
        }
    }
}

@Preview
@Composable
fun testHomeScreen() {
    MaterialTheme(
        colors = lightColors(
            background = AppWhite,
            surface = AppWhite,
        )
    ) {
        Surface() {
            Column() {
                HomeScreen(
                    uiState = testHomeUiState,
                    updateForecast = {},
                    onClickFavourite = {},
                )
            }
        }
    }
}