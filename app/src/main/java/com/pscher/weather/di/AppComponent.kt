package com.pscher.weather.di

import android.content.Context
import com.pscher.weather.navigation.NavModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Qualifier

@Component(modules = [NavModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@AppContext @BindsInstance context: Context): AppComponent
    }

    @AppContext
    fun provideAppContext(): Context
}

@Qualifier
annotation class AppContext