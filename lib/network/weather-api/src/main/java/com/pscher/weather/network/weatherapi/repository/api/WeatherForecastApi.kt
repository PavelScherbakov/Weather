package com.pscher.weather.network.weatherapi.repository.api

import com.pscher.weather.network.weatherapi.repository.response.ForecastResp
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface WeatherForecastApi {

    /**
     * Get the weather forecast for the city
     */
    @GET("/v1/forecast")
    suspend fun forecast(
        @Query("latitude") latitude: Float,
        @Query("longitude") longitude: Float,
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("daily") daily: List<String> = listOf("temperature_2m_max","temperature_2m_min"),
        @Query("timezone") timezone: String = TimeZone.getDefault().id,
        @Query("windspeed_unit") windSpeedUnit: String = "ms",
    ): ForecastResp
}