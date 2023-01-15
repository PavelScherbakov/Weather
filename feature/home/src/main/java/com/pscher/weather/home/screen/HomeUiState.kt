package com.pscher.weather.home.screen

import com.pscher.weather.core.model.Locality
import com.pscher.weather.core.model.defaultLocality
import com.pscher.weather.core.model.testLocality
import com.pscher.weather.network.weatherapi.repository.response.*

data class HomeUiState(
    val currentLocality: Locality,
    val currentWeather: CurrentWeather,
    val dailyForecastWeather: DailyForecastWeather,
)


val testHomeUiState = HomeUiState(
    currentLocality = testLocality,
    currentWeather = testCurrentWeather,
    dailyForecastWeather = testDailyForecastWeather,
)

val defaultHomeUiState = HomeUiState(
    currentLocality = defaultLocality,
    currentWeather = defaultCurrentWeather,
    dailyForecastWeather = defaultDailyForecastWeather,
)
