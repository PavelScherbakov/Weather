package com.pscher.weather.homeapi

import androidx.navigation.NavGraphBuilder

interface HomeNavGraph {
    fun NavGraphBuilder.addHomeNavGraph(
        navigationActions: HomeNavigationActions,
    )
}