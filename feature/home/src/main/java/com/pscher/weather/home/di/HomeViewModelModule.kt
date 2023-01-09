package com.pscher.weather.home.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.home.screen.HomeVM
import dagger.Binds
import dagger.Module

@Module
interface HomeViewModelModule {
    /*companion object{
        @Provides
        @AppScope
        fun provideHomeVM(): HomeVM {
            return HomeVM()
        }
    }*/

    /*@Binds
    @AppScope
    fun bindHomeVM(vm: HomeVM) : HomeVM*/
}