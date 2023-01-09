package com.pscher.weather.coreapi

import android.content.Context
import com.pscher.weather.coreapi.di.AppContext

interface AppProvider {
    @AppContext
    fun provideAppContext(): Context
}