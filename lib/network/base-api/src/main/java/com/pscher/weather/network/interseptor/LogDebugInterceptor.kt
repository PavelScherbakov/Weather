package com.pscher.weather.network.interseptor

import android.content.Context
import android.util.Log
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.pscher.weather.core.APP_LOG_TAG
import com.pscher.weather.network.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal fun addLogDebugInterceptor(
    context: Context,
    okHttpClientBuilder:  OkHttpClient.Builder
) {
    if (BuildConfig.DEBUG) {
        okHttpClientBuilder.apply {
            // add Chucker
            addInterceptor(
                ChuckerInterceptor.Builder(context)
                    .collector(ChuckerCollector(context))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
            addInterceptor(
                HttpLoggingInterceptor { message -> Log.d("${APP_LOG_TAG}_OkHttpClientLog", message) }
                    .apply { level = HttpLoggingInterceptor.Level.BODY }
            )
        }
    }
}