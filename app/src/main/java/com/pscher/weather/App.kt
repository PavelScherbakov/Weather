package com.pscher.weather

import android.app.Application
import com.pscher.weather.di.AppComponent
import com.pscher.weather.di.DaggerAppComponent

class App : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }

    fun getAppComponent(): AppComponent {
        return appComponent
    }
}