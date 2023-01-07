package com.pscher.weather.location

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pscher.weather.location.screen.FavouriteLocationScreen
import com.pscher.weather.location.screen.FavouriteLocationVM
import com.pscher.weather.locationapi.LocationDestinations
import com.pscher.weather.locationapi.LocationNavGraph
import com.pscher.weather.locationapi.LocationNavigationActions
import timber.log.Timber
import javax.inject.Inject

class LocationNavGraphImpl @Inject constructor(
    private val favouriteLocationVM: FavouriteLocationVM,
): LocationNavGraph {

    init {
        Timber.e("Create LocationNavGraphImpl")
    }

    override fun NavGraphBuilder.addLocationNavGraph(navigationActions: LocationNavigationActions) {
        composable(LocationDestinations.FAVOURITE_LOCATION_ROUTE) {
            FavouriteLocationScreen(
                navigationActions = navigationActions,
                favouriteLocationVM = favouriteLocationVM,
            )
        }
    }
}