package com.pscher.weather.di

import android.app.Application
import com.pscher.weather.coreapi.AppProvider
import com.pscher.weather.coreapi.ProvidersFacade
import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.datastore.di.DataStoreModule
import com.pscher.weather.geoapi.di.GeoApiModule
import com.pscher.weather.home.di.HomeNavigationModule
import com.pscher.weather.home.di.HomeViewModelModule
import com.pscher.weather.location.di.LocationNavigationModule
import com.pscher.weather.navigation.di.MasterNavigationModule
import com.pscher.weather.network.di.BaseApiModule
import com.pscher.weather.network.weatherapi.di.WeatherApiModule
import dagger.Component
import dagger.Module

@Component(
    dependencies = [AppProvider::class],
    modules = [NavigationModules::class, ViewModelModules::class, ApiModules::class, DataStoreModule::class]
)
@AppScope
interface FacadeComponent : ProvidersFacade {
    companion object {
        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder()
                .appProvider(AppComponent.create(application))
                .build()
    }

}

@Module(
    includes = [
        MasterNavigationModule::class,
        HomeNavigationModule::class,
        LocationNavigationModule::class,
    ]
)
interface NavigationModules

@Module(
    includes = [
        HomeViewModelModule::class,
    ]
)
interface ViewModelModules

@Module(
    includes = [
        BaseApiModule::class,
        WeatherApiModule::class,
        GeoApiModule::class,
    ]
)
interface ApiModules



