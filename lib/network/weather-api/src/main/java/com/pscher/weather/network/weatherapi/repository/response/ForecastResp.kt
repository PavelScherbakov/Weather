package com.pscher.weather.network.weatherapi.repository.response

import com.google.gson.annotations.SerializedName

data class ForecastResp(
    val latitude: Float,
    val longitude: Float,
    @SerializedName("current_weather")
    val currentWeather: CurrentWeather,
)

data class CurrentWeather(
    val time: String,
    val temperature: Float,
    @SerializedName("weathercode")
    val weatherCode: Int,
    @SerializedName("windspeed")
    val windSpeed: Float,
    @SerializedName("winddirection")
    val windDirection: Float,
)