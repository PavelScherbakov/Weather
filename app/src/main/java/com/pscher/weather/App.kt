package com.pscher.weather

import android.app.Application
import com.pscher.weather.coreapi.AppWithFacade
import com.pscher.weather.coreapi.ProvidersFacade
import com.pscher.weather.di.AppComponent
import com.pscher.weather.di.DaggerAppComponent
import com.pscher.weather.di.FacadeComponent
import timber.log.Timber

class App : Application(), AppWithFacade {

    companion object {
        private var facadeComponent: FacadeComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        getFacade()

        //Инициализируем логирование
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun log(
                    priority: Int, tag: String?, message: String, t: Throwable?
                ) {
                    super.log(priority, "WEATHER_$tag", message, t)
                }
            })
        }
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }
}