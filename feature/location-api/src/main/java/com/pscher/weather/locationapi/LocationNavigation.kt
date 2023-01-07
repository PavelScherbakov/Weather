package com.pscher.weather.locationapi

import com.pscher.weather.locationapi.LocationScreens.FAVOURITE_LOCATION_SCREEN

object LocationScreens {
    const val FAVOURITE_LOCATION_SCREEN = "FavouriteLocationScreen"
}

object LocationDestinationsArgs {
    //const val USER_MESSAGE_ARG = "userMessage"
}

object LocationDestinations {
    const val FAVOURITE_LOCATION_ROUTE = "$FAVOURITE_LOCATION_SCREEN"
}

interface LocationNavigationActions {
    fun openHomeScreen()
}