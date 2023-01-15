package com.pscher.weather.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.pscher.weather.ui.uikit.*
import com.pscher.weather.ui.uikit.view.DelimiterHorizontal
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import com.pscher.weather.resource.common.R as CommonR

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    updateForecast: suspend (Boolean) -> Unit,
    onClickFavourite: () -> Unit,
    onClickSetting: () -> Unit
) {
    LaunchedEffect(Unit) {
        Timber.e("Execute HomeScreen (first)")
    }

    val refreshState = rememberSwipeRefreshState(uiState.isUserRefresh)
    val scope = rememberCoroutineScope()

    //Запускаем периодическое обновление прогноза погоды когда приложение открыто
    val localLifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(Unit) {
        localLifecycleOwner.lifecycleScope.launchWhenResumed {
            while (true) {
                updateForecast(false)
                delay(60000L) //обновляем раз в минуту
            }
        }
    }

    //val scroll = rememberScrollState(0)

    Column(
        modifier = Modifier
            .background(
                color = AppThemeParam.colors.background
            )
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
                onClick = onClickFavourite
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = CommonR.drawable.ic_favourite_location),
                    tint = AppThemeParam.colors.text,
                    contentDescription = "Favourite location",
                )
            }

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = uiState.currentLocality.name,
                textAlign = TextAlign.Center,
                style = AppThemeParam.typography.header02,
                color = AppThemeParam.colors.text,
            )

            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp),
                onClick = onClickSetting
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = CommonR.drawable.ic_settings),
                    tint = AppThemeParam.colors.text,
                    contentDescription = "Open application setting",
                )
            }
        }

        SwipeRefresh(
            state = refreshState,
            onRefresh = {
                scope.launch {
                    updateForecast(true)
                }
            },
        ){
            LazyColumn(
                modifier = Modifier
                    .padding(top = 0.dp),
                userScrollEnabled = true,
            ) {

                //header
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = AppThemeParam.colors.materialColors.primary,
                                shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp,)
                            )
                    ) {
                        //Блок текущие показатели погоды
                        Text(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 16.dp),
                            text = "Текущие показатели",
                            style = AppThemeParam.typography.header02,
                            color = AppThemeParam.colors.text,
                        )

                        /*RowNameValue(
                            modifier = Modifier.padding(top = 16.dp),
                            name = "Дата:",
                            value = uiState.currentWeather.time,
                        )*/

                        RowNameValue(
                            modifier = Modifier.padding(top = 16.dp),
                            name = "Температура:",
                            value = "${uiState.currentWeather.temperature} °C",
                        )
                        RowNameValue(
                            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                            name = "Скорость ветра:",
                            value = "${uiState.currentWeather.windSpeed} м/с",
                        )
                    }
                }

                item {
                    //Блок прогноза погоды на 7 дней
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp),
                        text = "Прогноз на 7 дней",
                        textAlign = TextAlign.Center,
                        style = AppThemeParam.typography.header02,
                        color = AppThemeParam.colors.textSecondary,
                    )

                }

                itemsIndexed(
                    items = uiState.dailyForecastWeather.time,
                ) { index, item ->
                    WeatherForecastDayItem(
                        time = item,
                        temperatureMin = uiState.dailyForecastWeather.temperature2mMin[index],
                        temperatureMax = uiState.dailyForecastWeather.temperature2mMax[index],
                    )
                }
            }
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
                    onClickSetting = {},
                )
            }
        }
    }
}

@Composable
fun RowNameValue(
    modifier: Modifier = Modifier,
    name: String,
    value: String,
) {
    Row(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .alignByBaseline(),
            text = name,
            textAlign = TextAlign.End,
            style = AppThemeParam.typography.paragraph02,
            color = AppThemeParam.colors.text,
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            modifier = Modifier
                .weight(1f)
                .alignByBaseline(),
            text = value,
            textAlign = TextAlign.Start,
            style = AppThemeParam.typography.header01,
            color = AppThemeParam.colors.text,
        )
    }
}

@Composable
fun ColumnScope.WeatherForecastDayItem(
    time: String,
    temperatureMin: String,
    temperatureMax: String,
) {

    Column(
        modifier = Modifier
            .padding(start = 16.dp , end = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = time,
                textAlign = TextAlign.Center,
                style = AppThemeParam.typography.paragraph02,
                color = AppThemeParam.colors.textSecondary,
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 8.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline(),
                text = "Температура min:",
                textAlign = TextAlign.End,
                style = AppThemeParam.typography.paragraph02,
                color = AppThemeParam.colors.textSecondary,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline(),
                text = "$temperatureMin °C",
                textAlign = TextAlign.Start,
                style = AppThemeParam.typography.header02,
                color = AppThemeParam.colors.textSecondary,
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline(),
                text = "Температура max:",
                textAlign = TextAlign.End,
                style = AppThemeParam.typography.paragraph02,
                color = AppThemeParam.colors.textSecondary,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                modifier = Modifier
                    .weight(1f)
                    .alignByBaseline(),
                text = "$temperatureMax °C",
                textAlign = TextAlign.Start,
                style = AppThemeParam.typography.header02,
                color = AppThemeParam.colors.textSecondary,
            )
        }

        DelimiterHorizontal(
            color = AppDark20,
            modifier = Modifier.padding(top = 16.dp),
        )
    }
}