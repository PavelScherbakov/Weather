package com.pscher.weather.network.weatherapi.repository

import com.pscher.weather.network.weatherapi.repository.api.WeatherForecastApi
import com.pscher.weather.network.weatherapi.repository.response.ForecastResp
import retrofit2.http.Query
import timber.log.Timber
import javax.inject.Inject


interface WeatherForecastRepository {
    suspend fun getForecast(
        latitude: Float,
        longitude: Float,
    ): ForecastResp
}

class WeatherForecastRepositoryImpl @Inject constructor(
    private val weatherForecastApi: WeatherForecastApi,
): WeatherForecastRepository {

    override suspend fun getForecast(
        latitude: Float,
        longitude: Float,
    ): ForecastResp {
        Timber.e("getForecast")
        return weatherForecastApi.forecast(
            latitude = latitude,
            longitude = longitude,
        )
    }
}