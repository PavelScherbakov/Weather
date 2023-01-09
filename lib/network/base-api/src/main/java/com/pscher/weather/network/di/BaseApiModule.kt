package com.pscher.weather.network.di

import android.content.Context
import com.pscher.weather.coreapi.di.AppContext
import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.network.buildOkHttpClientBase
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Qualifier

@Module
interface BaseApiModule {
    companion object {
        @Provides
        @AppScope
        @BaseOkHttpclient
        fun provideBaseOkHttpClient(@AppContext context: Context): OkHttpClient {
            return buildOkHttpClientBase(context)
        }
    }
}

@Qualifier
annotation class BaseOkHttpclient