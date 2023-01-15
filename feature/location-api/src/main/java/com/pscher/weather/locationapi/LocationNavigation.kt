package com.pscher.weather.locationapi

import com.pscher.weather.locationapi.LocationScreens.FAVOURITE_LOCATION_SCREEN
import com.pscher.weather.locationapi.LocationScreens.SEARCH_SCREEN

object LocationScreens {
    const val FAVOURITE_LOCATION_SCREEN = "FavouriteLocationScreen"
    const val SEARCH_SCREEN = "SearchScreen"
}

object LocationDestinationsArgs {
    //const val USER_MESSAGE_ARG = "userMessage"
}

object LocationDestinations {
    const val FAVOURITE_LOCATION_ROUTE = "$FAVOURITE_LOCATION_SCREEN"
    const val SEARCH_ROUTE = "$SEARCH_SCREEN"
}

interface LocationNavigationActions {
    fun back()
    fun openHomeScreen(localityId: Int)
    fun openSearchScreen()
}