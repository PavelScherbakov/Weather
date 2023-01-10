package com.pscher.weather.home.screen

import com.pscher.weather.network.weatherapi.repository.WeatherForecastRepository
import com.pscher.weather.network.weatherapi.repository.response.ForecastResp
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class HomeVM @Inject constructor(
    private val weatherForecastRepository: WeatherForecastRepository,
    //todo надо получать lifecycle активити и учитывать при выполнении корутин
): CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main + CoroutineName("HomeCoroutine")

    init {
        Timber.e("Create HomeVM")
    }

    private val _homeUiState = MutableStateFlow(defaultHomeUiState)
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    /**
     * Обновление данных по прогнозу
     */
    suspend fun updateForecast() {
        Timber.e("HomeVM updateForecast")
        val response = weatherForecastRepository.getForecast(
            latitude = 57.81f,
            longitude = 28.35f,
        )

        changeHomeUiState(response)

        Timber.e("HomeVM updateForecast response = $response")
    }

    private fun changeHomeUiState(forecast: ForecastResp) {
        _homeUiState.update {
            it.copy(
                temperature = forecast.currentWeather.temperature.toString()
            )
        }
    }

}