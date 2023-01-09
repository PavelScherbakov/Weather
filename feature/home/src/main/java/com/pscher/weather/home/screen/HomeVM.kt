package com.pscher.weather.home.screen

import com.pscher.weather.network.weatherapi.repository.WeatherForecastRepository
import kotlinx.coroutines.*
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
        launch {
            weatherForecastRepository.getForecast()
        }
    }

    val title = "HomeScreen!!!"

}