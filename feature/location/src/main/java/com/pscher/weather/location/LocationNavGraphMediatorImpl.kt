package com.pscher.weather.location

import com.pscher.weather.locationapi.LocationNavGraph
import com.pscher.weather.locationapi.LocationNavGraphMediator
import timber.log.Timber
import javax.inject.Inject

class LocationNavGraphMediatorImpl
@Inject constructor(
    private val locationNavGraph: LocationNavGraph,
) : LocationNavGraphMediator {

    init {
        Timber.e("Create LocationNavGraphMediatorImpl")
    }

    override fun provideLocationNavGraph(): LocationNavGraph {
        return locationNavGraph
    }
}