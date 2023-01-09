package com.pscher.weather.main.di

import com.pscher.weather.coreapi.ProvidersFacade
import com.pscher.weather.main.MainActivity
import com.pscher.weather.navigationapi.MasterNavGraphMediator
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Component(
    dependencies = [ProvidersFacade::class],
    modules = [MainActivityModule::class],
)
interface MainActivityComponent {

    companion object {
        fun create(providersFacade: ProvidersFacade): MainActivityComponent {
            return DaggerMainActivityComponent
                .factory().create(providersFacade)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(providersFacade: ProvidersFacade): MainActivityComponent
    }

    /*@MainActivityLifecycleScope
    fun provideMainActivityLifecycleCoroutineScope(): LifecycleCoroutineScope*/


    fun inject (mainActivity: MainActivity)
}

@Module
interface MainActivityModule {
    companion object{
        @Provides
        fun provideMasterNavGraphMediator(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): MasterNavGraphMediator {
            return map[MasterNavGraphMediator::class.java]!!.get() as MasterNavGraphMediator
        }
    }
}