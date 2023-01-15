package com.pscher.weather.setting.di

import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.setting.SettingNavGraphImpl
import com.pscher.weather.setting.SettingNavGraphMediatorImpl
import com.pscher.weather.settingapi.SettingNavGraph
import com.pscher.weather.settingapi.SettingNavGraphMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface SettingNavigationModule {
    @Binds
    @IntoMap
    @ClassKey(SettingNavGraphMediator::class)
    fun bindSettingNavGraphMediator(mediator: SettingNavGraphMediatorImpl): Any

    @Binds
    @AppScope
    fun bindSettingNavGraph(navGraph: SettingNavGraphImpl): SettingNavGraph

    companion object{
        @Provides
        @AppScope
        fun provideSettingNavGraphMediatorImpl(navGraph: SettingNavGraph): SettingNavGraphMediatorImpl {
            return SettingNavGraphMediatorImpl(
                settingNavGraph = navGraph,
            )
        }
    }
}