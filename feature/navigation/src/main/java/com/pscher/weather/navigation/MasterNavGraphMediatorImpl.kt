package com.pscher.weather.navigation

import com.pscher.weather.navigationapi.MasterNavGraph
import com.pscher.weather.navigationapi.MasterNavGraphMediator
import timber.log.Timber
import javax.inject.Inject

class MasterNavGraphMediatorImpl
@Inject constructor(
    //private val homeNavGraphMediator: HomeNavGraphMediator,
    //private val locationGraphMediator: LocationNavGraphMediator,
    private val masterNavGraph: MasterNavGraph,
) : MasterNavGraphMediator {

    init {
        Timber.e("Create MasterNavGraphMediatorImpl")
    }

    override fun provideMasterNavGraph(): MasterNavGraph {
        return /*MasterNavGraphImpl(
            homeNavGraphMediator = homeNavGraphMediator,
            locationNavGraphMediator = locationGraphMediator,
        )*/masterNavGraph
    }
}