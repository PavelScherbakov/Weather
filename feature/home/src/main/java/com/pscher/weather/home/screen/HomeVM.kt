package com.pscher.weather.home.screen

import com.pscher.weather.core.model.Locality
import com.pscher.weather.core.model.defaultLocality
import com.pscher.weather.datastore.repository.AppDataRepository
import com.pscher.weather.datastore.repository.room.entity.toLocality
import com.pscher.weather.network.weatherapi.repository.WeatherForecastRepository
import com.pscher.weather.network.weatherapi.repository.response.ForecastResp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class HomeVM @Inject constructor(
    private val weatherForecastRepository: WeatherForecastRepository,
    private val appDataRepository: AppDataRepository,
) {

    init {
        Timber.e("Create HomeVM")
    }

    private val _homeUiState = MutableStateFlow(defaultHomeUiState)
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()
    init {
        //Устанавливаем сохранённое ранее текущее местоположения
        runBlocking(Dispatchers.IO) {
            val currentLocalityId = appDataRepository.appSettingDataStore().currentLocalityId().get().firstOrNull()
            Timber.e("HomeVM init currentLocalityId = $currentLocalityId")
            setCurrentLocality(currentLocalityId ?: 0)
        }
    }


    suspend fun setCurrentLocality(localityId: Int) {
        Timber.e("HomeVM setCurrentLocality localityId = $localityId")

        if (localityId == -1) return

        //Получаем местоположение из базы по id
        val currentLocality: Locality =
            try {
                appDataRepository.localityDao().loadById(localityId).toLocality()
            }
            catch (e: Exception) {
                Timber.e(e)
                defaultLocality
            }

        _homeUiState.update { homeUiState ->
            homeUiState.copy(
                currentLocality = currentLocality,
            )
        }
    }

    /**
     * Обновление данных по прогнозу
     */
    suspend fun updateForecast(isUserRefresh: Boolean = false) {
        Timber.e("HomeVM updateForecast timezone = ${TimeZone.getDefault().id}")

        _homeUiState.update { homeUiState ->
            homeUiState.copy(
                isUserRefresh = isUserRefresh,
            )
        }

        val response = weatherForecastRepository.getForecast(
            latitude = homeUiState.value.currentLocality.latitude,
            longitude = homeUiState.value.currentLocality.longitude,
        )

        changeHomeUiState(response)

        Timber.e("HomeVM updateForecast response = $response")
    }

    private fun changeHomeUiState(forecast: ForecastResp) {
        _homeUiState.update { currentHomeUiState ->
            currentHomeUiState.copy(
                isUserRefresh = false,
                currentWeather = forecast.currentWeather,
                dailyForecastWeather = forecast.daily,
            )
        }
    }
}