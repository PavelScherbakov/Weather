package com.pscher.weather.locationapi

import androidx.navigation.NavGraphBuilder

interface LocationNavGraph {
    fun NavGraphBuilder.addLocationNavGraph(navigationActions: LocationNavigationActions)
}