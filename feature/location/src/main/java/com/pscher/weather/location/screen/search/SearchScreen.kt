package com.pscher.weather.location.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pscher.weather.core.model.Locality
import com.pscher.weather.location.screen.search.view.SearchText
import com.pscher.weather.ui.uikit.*
import com.pscher.weather.ui.uikit.view.DelimiterHorizontal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import com.pscher.weather.resource.common.R as CommonR

@Composable
fun SearchScreen(
    uiState: SearchUiState,
    onClickBack: () -> Unit,
    onSearch: suspend (String?) -> Unit,
    onClickItem: (Locality) -> Unit,
) {
    LaunchedEffect(Unit) {
        Timber.e("Execute SearchScreen")
    }

    val scope: CoroutineScope = rememberCoroutineScope()
    val searchFocusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        scope.launch {
            searchFocusRequester.requestFocus()
        }
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


            SearchText(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(end = 16.dp),
                search = uiState.search,
                enabled = true,
                onSearch = { search ->
                    scope.launch {
                        onSearch(search)
                    }
                },
                focusRequester = searchFocusRequester
            )
        }

        if (uiState.resultSearch.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .padding(top = 0.dp),
                userScrollEnabled = true,
            ) {
                items(
                    items = uiState.resultSearch,
                    //key = { it.id },
                ) { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onClickItem(item) }
                    ) {
                        Row(
                            modifier = Modifier
                                .height(60.dp)
                                .align(Alignment.Center)
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.CenterVertically),
                                text = "${item.name}, ${item.country}",
                                textAlign = TextAlign.Center,
                                style = AppThemeParam.typography.paragraph01,
                                color = AppThemeParam.colors.textSecondary,
                            )
                        }
                    }

                    DelimiterHorizontal()
                }
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
                SearchScreen(
                    uiState = testSearchUiState,
                    onClickBack = {},
                    onSearch = {},
                    onClickItem = {},
                )
            }
        }
    }
}