package com.pscher.weather.network.weatherapi.repository.api

import com.pscher.weather.network.weatherapi.repository.response.ForecastResp
import retrofit2.http.GET

interface WeatherForecastApi {

    /**
     * Get the weather forecast for the city
     */
    //@GET("/v1/forecast")
    @GET("/v1/forecast?latitude=57.81&longitude=28.35&current_weather=true&hourly=temperature_2m")
    suspend fun forecast(

    ): ForecastResp

}