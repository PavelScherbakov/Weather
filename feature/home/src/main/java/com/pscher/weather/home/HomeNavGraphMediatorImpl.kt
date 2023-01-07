package com.pscher.weather.home

import com.pscher.weather.homeapi.HomeNavGraph
import com.pscher.weather.homeapi.HomeNavGraphMediator
import timber.log.Timber
import javax.inject.Inject

class HomeNavGraphMediatorImpl
@Inject constructor(
    private val homeNavGraph: HomeNavGraph,
) : HomeNavGraphMediator {

    init {
        Timber.e("Create HomeNavGraphMediatorImpl")
    }

    override fun provideHomeNavGraph(): HomeNavGraph {
        return homeNavGraph
    }
}