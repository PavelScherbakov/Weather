package com.pscher.weather.home.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.pscher.weather.ui.uikit.AppWhite
import com.pscher.weather.ui.uikit.view.DelimiterHorizontal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import timber.log.Timber
import com.pscher.weather.resource.common.R as CommonR

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
                delay(60000L)
            }
        }
    }

    val scroll = rememberScrollState(0)

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
                onClick = onClickFavourite
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = CommonR.drawable.ic_favourite_location),
                    contentDescription = "Favourite location",
                )
            }

            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                text = uiState.currentLocality.name,
                textAlign = TextAlign.Center,
            )

            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 8.dp),
                onClick = onClickFavourite
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(id = CommonR.drawable.ic_settings),
                    contentDescription = "Favourite location",
                )
            }

        }

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
                ) {
                    //Блок текущие показатели погоды
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 16.dp),
                        text = "Текущие показатели",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight(600)
                        )
                    )

                    RowNameValue(
                        modifier = Modifier.padding(top = 16.dp),
                        name = "Дата:",
                        value = uiState.currentWeather.time,
                    )

                    RowNameValue(
                        modifier = Modifier.padding(top = 16.dp),
                        name = "Температура:",
                        value = "${uiState.currentWeather.temperature} °C",
                    )
                    RowNameValue(
                        modifier = Modifier.padding(top = 16.dp),
                        name = "Скорость ветра:",
                        value = "${uiState.currentWeather.windSpeed} м/с",
                    )


                    //Блок прогноза погоды на 7 дней
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 32.dp),
                        text = "Прогноз на 7 дней",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight(600)
                        )
                    )
                }
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
            modifier = Modifier.weight(1f),
            text = name,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            modifier = Modifier.weight(1f),
            text = value,
            textAlign = TextAlign.Start
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
                text = "Дата:",
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                modifier = Modifier.weight(1f),
                text = time,
                textAlign = TextAlign.Start
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Температура min:",
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                modifier = Modifier.weight(1f),
                text = temperatureMin,
                textAlign = TextAlign.Start
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "Температура max:",
                textAlign = TextAlign.End
            )

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                modifier = Modifier.weight(1f),
                text = temperatureMax,
                textAlign = TextAlign.Start
            )
        }

        DelimiterHorizontal(modifier = Modifier.padding(top = 16.dp))
    }



}