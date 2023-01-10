package com.pscher.weather.network.weatherapi.repository.api

import com.pscher.weather.network.weatherapi.repository.response.ForecastResp
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherForecastApi {

    /**
     * Get the weather forecast for the city
     */
    @GET("/v1/forecast")
    suspend fun forecast(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float,
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("hourly") hourly: String = "temperature_2m",
    ): ForecastResp
}