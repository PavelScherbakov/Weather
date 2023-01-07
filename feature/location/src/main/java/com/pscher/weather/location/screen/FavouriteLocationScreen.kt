package com.pscher.weather.location.screen

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
import com.pscher.weather.locationapi.LocationNavigationActions
import com.pscher.weather.ui.uikit.AppWhite
import timber.log.Timber

@Composable
fun FavouriteLocationScreen(
    navigationActions: LocationNavigationActions,
    favouriteLocationVM: FavouriteLocationVM,
) {
    LaunchedEffect(Unit) {
        Timber.e("Execute FavouriteLocationScreen")
    }

    val favouriteLocationVM = favouriteLocationVM

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = favouriteLocationVM.title,
        )

        Button(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            onClick = { navigationActions.openHomeScreen() }
        ) {
            Text(text = "Go to HomeScreen")
        }
    }
}

@Preview
@Composable
fun testFavouriteLocationScreen() {
    MaterialTheme(
        colors = lightColors(
            background = AppWhite,
            surface = AppWhite,
        )
    ) {
        Surface() {
            Column() {
                FavouriteLocationScreen(
                    navigationActions = object : LocationNavigationActions {
                        override fun openHomeScreen() {}
                    },
                    favouriteLocationVM = FavouriteLocationVM(),
                )
            }
        }
    }
}