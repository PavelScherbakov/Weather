package com.pscher.weather.network.weatherapi.repository.response

import com.google.gson.annotations.SerializedName

data class ForecastResp(
    val latitude: Float,
    val longitude: Float,
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
    val daily: DailyForecastWeather,
)

data class CurrentWeather(
    val time: String,
    val temperature: String,
    @SerializedName("weathercode")
    val weatherCode: String,
    @SerializedName("windspeed")
    val windSpeed: String,
    @SerializedName("winddirection")
    val windDirection: String,
)

data class DailyForecastWeather(
    val time: List<String>,
    @SerializedName("temperature_2m_max")
    val temperature2mMax: List<String>,
    @SerializedName("temperature_2m_min")
    val temperature2mMin: List<String>,
)

val testCurrentWeather = CurrentWeather(
    time = "2023-01-10T18:00",
    temperature = "-2.6",
    weatherCode = "73",
    windSpeed = "6.9",
    windDirection = "161.0",
)

val defaultCurrentWeather = CurrentWeather(
    time = "2023-01-10T18:00",
    temperature = "-",
    weatherCode = "-",
    windSpeed = "-",
    windDirection = "-",
)

val testDailyForecastWeather = DailyForecastWeather(
    time = listOf("2023-01-11","2023-01-12","2023-01-13","2023-01-14","2023-01-15","2023-01-16","2023-01-17"),
    temperature2mMax = listOf("-2.9","-1.8","2.4","1.3","1.3","1.4","1.0"),
    temperature2mMin = listOf("-3.6","-3.6","-1.6","0.6","0.7","0.9","-0.4"),
)

val defaultDailyForecastWeather = DailyForecastWeather(
    time = listOf(),
    temperature2mMax = listOf(),
    temperature2mMin = listOf(),
)