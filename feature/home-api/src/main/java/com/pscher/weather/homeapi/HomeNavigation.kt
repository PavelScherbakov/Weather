package com.pscher.weather.homeapi

import com.pscher.weather.homeapi.HomeDestinationsArgs.LOCALITY_ID_ARG
import com.pscher.weather.homeapi.HomeScreens.HOME_SCREEN

object HomeScreens {
    const val HOME_SCREEN = "HomeScreen"
}

object HomeDestinationsArgs {
    const val LOCALITY_ID_ARG = "localityId"
}

object HomeDestinations {
    const val HOME_ROUTE = "$HOME_SCREEN/{$LOCALITY_ID_ARG}"
}

interface HomeNavigationActions {
    fun openFavouriteLocationScreen()
    fun openSettingScreen()
}