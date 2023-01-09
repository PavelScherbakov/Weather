package com.pscher.weather.network

import android.content.Context
import com.pscher.weather.network.interseptor.addLogDebugInterceptor
import okhttp3.OkHttpClient
import timber.log.Timber
import java.util.concurrent.TimeUnit

internal fun buildOkHttpClientBase(context: Context): OkHttpClient =
    OkHttpClient.Builder()
        .apply {
            Timber.e("Create OkHttpClient")
            connectTimeout(OkHttpClientConst.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(OkHttpClientConst.READ_TIMEOUT, TimeUnit.SECONDS)

            addLogDebugInterceptor(context, this)

            followRedirects(false)
        }.build()


