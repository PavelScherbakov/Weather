package com.pscher.weather.location.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.location.LocationNavGraphImpl
import com.pscher.weather.location.LocationNavGraphMediatorImpl
import com.pscher.weather.locationapi.LocationNavGraph
import com.pscher.weather.locationapi.LocationNavGraphMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface LocationNavigationModule {
    @Binds
    @IntoMap
    @ClassKey(LocationNavGraphMediator::class)
    fun bindLocationNavGraphMediator(mediator: LocationNavGraphMediatorImpl): Any

    @Binds
    @AppScope
    fun bindLocationNavGraph(homeNavGraph: LocationNavGraphImpl): LocationNavGraph

    companion object{
        @Provides
        @AppScope
        fun provideLocationNavGraphMediatorImpl(locationNavGraph: LocationNavGraph): LocationNavGraphMediatorImpl {
            return LocationNavGraphMediatorImpl(
                locationNavGraph = locationNavGraph,
            )
        }
    }
}