package com.pscher.weather.home.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.home.HomeNavGraphImpl
import com.pscher.weather.home.HomeNavGraphMediatorImpl
import com.pscher.weather.homeapi.HomeNavGraph
import com.pscher.weather.homeapi.HomeNavGraphMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface HomeNavigationModule {
    @Binds
    @IntoMap
    @ClassKey(HomeNavGraphMediator::class)
    fun bindHomeNavGraphMediator(mediator: HomeNavGraphMediatorImpl): Any

    @Binds
    @AppScope
    fun bindHomeNavGraph(homeNavGraph: HomeNavGraphImpl): HomeNavGraph

    companion object{
        @Provides
        @AppScope
        fun provideHomeNavGraphMediatorImpl(homeNavGraph: HomeNavGraph): HomeNavGraphMediatorImpl {
            return HomeNavGraphMediatorImpl(
                homeNavGraph = homeNavGraph,
            )
        }
    }
}