package com.pscher.weather.navigation

import com.pscher.weather.navigationapi.Router
import dagger.Binds
import dagger.Module

@Module
interface NavModule {
    @Binds
    fun bindRouter(router: RouterImpl): Router
}