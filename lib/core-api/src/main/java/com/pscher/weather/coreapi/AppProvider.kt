package com.pscher.weather.coreapi

import android.content.Context

interface AppProvider {
    fun provideContext(): Context
}