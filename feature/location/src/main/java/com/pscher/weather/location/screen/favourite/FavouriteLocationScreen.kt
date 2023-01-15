package com.pscher.weather.location.screen.favourite

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscher.weather.core.model.Locality
import com.pscher.weather.ui.uikit.AppDark10
import com.pscher.weather.ui.uikit.AppDark20
import com.pscher.weather.ui.uikit.AppWhite
import com.pscher.weather.ui.uikit.view.DelimiterHorizontal
import timber.log.Timber
import com.pscher.weather.resource.common.R as CommonR

@Composable
fun FavouriteLocationScreen(
    uiState: FavouriteLocationUiState,
    onClickBack: () -> Unit,
    onClickSearch: () -> Unit,
    onClickFavourite: (Locality) -> Unit,
) {
    LaunchedEffect(Unit) {
        Timber.e("Execute FavouriteLocationScreen")

        //Обновляем список избранных

    }

    Column() {
        //ActionBar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
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
                    contentDescription = "Back",
                )
            }

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = "Избранное",
                textAlign = TextAlign.Center,
            )

            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp),
                onClick = onClickSearch
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = CommonR.drawable.ic_search),
                    contentDescription = "Favourite location",
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 0.dp),
            userScrollEnabled = true,
        ) {
            items(
                items = uiState.favouriteList,
                key = { it.id },
            ) { favouriteLocality ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(AppDark10)
                        .clickable { onClickFavourite(favouriteLocality) }
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically),
                        text = favouriteLocality.name,
                        textAlign = TextAlign.Center
                    )
                }

                DelimiterHorizontal(color = AppDark20)
            }
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
                    uiState = testFavouriteLocationUiState,
                    onClickBack = {},
                    onClickFavourite = {},
                    onClickSearch = {},
                )
            }
        }
    }
}