package com.pscher.weather.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.pscher.weather.homeapi.HomeDestinations
import com.pscher.weather.homeapi.HomeNavGraphMediator
import com.pscher.weather.homeapi.HomeNavigationActions
import com.pscher.weather.locationapi.LocationDestinations
import com.pscher.weather.locationapi.LocationNavGraphMediator
import com.pscher.weather.locationapi.LocationNavigationActions
import com.pscher.weather.navigationapi.MasterDestinations
import com.pscher.weather.navigationapi.MasterNavGraph
import timber.log.Timber
import javax.inject.Inject

class MasterNavGraphImpl @Inject constructor(
    private val homeNavGraphMediator: HomeNavGraphMediator,
    private val locationNavGraphMediator: LocationNavGraphMediator,
): MasterNavGraph, HomeNavigationActions, LocationNavigationActions {

    init {
        Timber.e("Create MasterNavGraphImpl")
    }

    private lateinit var navController: NavHostController

    @Composable
    override fun MasterNavHostGraph() {

        LaunchedEffect(Unit) {
            Timber.e("Execute MasterNavHostGraph")
        }

        val navController = rememberNavController()

        LaunchedEffect(navController) {
            this@MasterNavGraphImpl.navController = navController
        }

        NavHost(
            navController = navController,
            startDestination = MasterDestinations.HOME_GRAPH_ROUTE,
        ) {

            navigation(
                startDestination = HomeDestinations.HOME_ROUTE,
                route = MasterDestinations.HOME_GRAPH_ROUTE,
            ) {
                homeNavGraphMediator.provideHomeNavGraph().apply {
                    addHomeNavGraph(this@MasterNavGraphImpl)
                }
            }

            navigation(
                startDestination = LocationDestinations.FAVOURITE_LOCATION_ROUTE,
                route = MasterDestinations.LOCATION_GRAPH_ROUTE,
            ) {
                locationNavGraphMediator.provideLocationNavGraph().apply {
                    addLocationNavGraph(this@MasterNavGraphImpl)
                }
            }
        }

    }

    override fun openFavouriteLocationScreen() {
        navController.navigate(LocationDestinations.FAVOURITE_LOCATION_ROUTE)
    }

    override fun openHomeScreen() {
        navController.navigate(
            route = HomeDestinations.HOME_ROUTE,
            navOptions = NavOptions.Builder().setPopUpTo(
                route = HomeDestinations.HOME_ROUTE,
                inclusive = true,
            ).build()
        )
    }
}