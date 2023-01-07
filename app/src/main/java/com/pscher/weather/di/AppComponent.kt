package com.pscher.weather.di

import android.app.Application
import android.content.Context
import com.pscher.weather.coreapi.AppProvider
import dagger.BindsInstance
import dagger.Component

@Component
interface AppComponent: AppProvider {

    companion object {
        private var appComponent: AppProvider? = null

        fun create(application: Application): AppProvider {
            return appComponent ?: DaggerAppComponent
                .factory().create(application).also {
                    appComponent = it
                }
        }
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}