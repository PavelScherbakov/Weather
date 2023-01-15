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
import com.pscher.weather.ui.uikit.AppThemeParam
import com.pscher.weather.ui.uikit.appToolbarHeightDp
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
                text = "Избранное",
                textAlign = TextAlign.Center,
                style = AppThemeParam.typography.header03,
                color = AppThemeParam.colors.text,
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
                    tint = AppThemeParam.colors.text,
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
                        text = "${favouriteLocality.name}, ${favouriteLocality.country}",
                        textAlign = TextAlign.Center,
                        style = AppThemeParam.typography.paragraph01,
                        color = AppThemeParam.colors.textSecondary,
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
            background = AppThemeParam.colors.background,
            surface = AppThemeParam.colors.background,
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