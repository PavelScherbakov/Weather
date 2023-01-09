package com.pscher.weather.network.weatherapi.repository

import com.pscher.weather.network.weatherapi.repository.api.WeatherForecastApi
import com.pscher.weather.network.weatherapi.repository.response.ForecastResp
import timber.log.Timber
import javax.inject.Inject


interface WeatherForecastRepository {
    suspend fun getForecast(): ForecastResp
}

class WeatherForecastRepositoryImpl @Inject constructor(
    private val weatherForecastApi: WeatherForecastApi,
): WeatherForecastRepository {

    override suspend fun getForecast(): ForecastResp {
        Timber.e("getForecast")
        return weatherForecastApi.forecast()
    }
}