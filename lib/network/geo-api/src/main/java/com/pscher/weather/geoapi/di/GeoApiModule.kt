package com.pscher.weather.geoapi.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.geoapi.repository.GeoRepository
import com.pscher.weather.geoapi.repository.GeoRepositoryImpl
import com.pscher.weather.geoapi.repository.api.GeoApi
import com.pscher.weather.network.di.BaseOkHttpclient
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module
interface GeoApiModule {
    companion object{
        @Provides
        @AppScope
        @GeoRetrofit
        fun provideGeoRetrofit(
            @BaseOkHttpclient okHttpClient: OkHttpClient,
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://geocoding-api.open-meteo.com/") //todo убрать урл в конфиг
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        @AppScope
        fun provideGeoApi(
            @GeoRetrofit geoRetrofit: Retrofit,
        ): GeoApi {
            return geoRetrofit.create(GeoApi::class.java)
        }
    }

    @Binds
    fun bindGeoRepository(repository: GeoRepositoryImpl): GeoRepository
}

@Qualifier
annotation class GeoRetrofit