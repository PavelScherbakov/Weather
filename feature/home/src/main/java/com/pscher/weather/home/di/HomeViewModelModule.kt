package com.pscher.weather.home.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.home.screen.HomeVM
import dagger.Module
import dagger.Provides

@Module
interface HomeViewModelModule {
    companion object{
        @Provides
        @AppScope
        fun provideHomeVM(): HomeVM {
            return HomeVM()
        }
    }
}