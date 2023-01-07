package com.pscher.weather.homeapi

import com.pscher.weather.homeapi.HomeScreens.HOME_SCREEN

object HomeScreens {
    const val HOME_SCREEN = "HomeScreen"
}

object HomeDestinationsArgs {
    //const val USER_MESSAGE_ARG = "userMessage"
}

object HomeDestinations {
    const val HOME_ROUTE = "$HOME_SCREEN"
}

interface HomeNavigationActions {
    fun openFavouriteLocationScreen()
}