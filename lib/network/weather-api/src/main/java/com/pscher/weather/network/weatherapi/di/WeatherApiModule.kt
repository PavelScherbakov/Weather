package com.pscher.weather.network.weatherapi.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.network.di.BaseOkHttpclient
import com.pscher.weather.network.weatherapi.repository.WeatherForecastRepository
import com.pscher.weather.network.weatherapi.repository.WeatherForecastRepositoryImpl
import com.pscher.weather.network.weatherapi.repository.api.WeatherForecastApi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module
interface WeatherApiModule {
    companion object{
        @Provides
        @AppScope
        @WeatherRetrofit
        fun provideWeatherRetrofit(
            @BaseOkHttpclient okHttpClient: OkHttpClient,
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.open-meteo.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @AppScope
        fun provideWeatherForecastApi(
            @WeatherRetrofit weatherRetrofit: Retrofit,
        ): WeatherForecastApi {
            return weatherRetrofit.create(WeatherForecastApi::class.java)
        }
    }

    @Binds
    fun bindWeatherForecastRepository(repository: WeatherForecastRepositoryImpl): WeatherForecastRepository
}

@Qualifier
annotation class WeatherRetrofit