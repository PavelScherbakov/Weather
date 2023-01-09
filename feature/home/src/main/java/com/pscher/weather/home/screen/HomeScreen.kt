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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscher.weather.homeapi.HomeNavigationActions
import com.pscher.weather.ui.uikit.AppWhite
import timber.log.Timber

@Composable
fun HomeScreen(
    navigationActions: HomeNavigationActions,
    title: String,
) {
    LaunchedEffect(Unit) {
        Timber.e("Execute HomeScreen")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = title,
        )

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            onClick = { navigationActions.openFavouriteLocationScreen() }
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
                    navigationActions = object : HomeNavigationActions {
                        override fun openFavouriteLocationScreen() {}
                    },
                    title = "Title",
                )
            }
        }
    }
}