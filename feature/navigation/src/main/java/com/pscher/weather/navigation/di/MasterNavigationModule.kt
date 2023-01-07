package com.pscher.weather.navigation.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.homeapi.HomeNavGraphMediator
import com.pscher.weather.locationapi.LocationNavGraphMediator
import com.pscher.weather.navigation.MasterNavGraphImpl
import com.pscher.weather.navigation.MasterNavGraphMediatorImpl
import com.pscher.weather.navigationapi.MasterNavGraph
import com.pscher.weather.navigationapi.MasterNavGraphMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Provider


@Module
interface MasterNavigationModule {
    @Binds
    @IntoMap
    @ClassKey(MasterNavGraphMediator::class)
    fun bindMasterNavGraphMediator(mediator: MasterNavGraphMediatorImpl): Any

    @Binds
    @AppScope
    fun bindMasterNavGraph(masterNavGraph: MasterNavGraphImpl): MasterNavGraph

    companion object{
        @Provides
        @AppScope
        fun provideMasterNavGraphMediatorImpl(masterNavGraph: MasterNavGraph): MasterNavGraphMediatorImpl {
            return MasterNavGraphMediatorImpl(
                masterNavGraph = masterNavGraph,
            )
        }

        @Provides
        @AppScope
        fun provideMasterNavGraphImpl(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): MasterNavGraphImpl {
            return MasterNavGraphImpl(
                homeNavGraphMediator = map[HomeNavGraphMediator::class.java]!!.get() as HomeNavGraphMediator,
                locationNavGraphMediator = map[LocationNavGraphMediator::class.java]!!.get() as LocationNavGraphMediator,
            )
        }
    }
}