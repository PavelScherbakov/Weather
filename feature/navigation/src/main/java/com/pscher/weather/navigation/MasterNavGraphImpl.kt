package com.pscher.weather.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.pscher.weather.homeapi.*
import com.pscher.weather.locationapi.LocationDestinations
import com.pscher.weather.locationapi.LocationNavGraphMediator
import com.pscher.weather.locationapi.LocationNavigationActions
import com.pscher.weather.navigationapi.MasterDestinations
import com.pscher.weather.navigationapi.MasterNavGraph
import com.pscher.weather.settingapi.SettingDestinations
import com.pscher.weather.settingapi.SettingNavGraphMediator
import com.pscher.weather.settingapi.SettingNavigationActions
import timber.log.Timber
import javax.inject.Inject

class MasterNavGraphImpl @Inject constructor(
    private val homeNavGraphMediator: HomeNavGraphMediator,
    private val locationNavGraphMediator: LocationNavGraphMediator,
    private val settingNavGraphMediator: SettingNavGraphMediator,
): MasterNavGraph, HomeNavigationActions, LocationNavigationActions, SettingNavigationActions {

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

            navigation(
                startDestination = SettingDestinations.SETTING_ROUTE,
                route = MasterDestinations.SETTING_GRAPH_ROUTE,
            ) {
                settingNavGraphMediator.provideSettingNavGraph().apply {
                    addSettingNavGraph(this@MasterNavGraphImpl)
                }
            }

        }

    }

    override fun openFavouriteLocationScreen() {
        navController.navigate(LocationDestinations.FAVOURITE_LOCATION_ROUTE)
    }

    override fun openSettingScreen() {
        navController.navigate(SettingDestinations.SETTING_ROUTE)
    }

    override fun openHomeScreen(localityId: Int) {
        navController.navigate(
            route = HomeDestinations.HOME_ROUTE.replace(
                oldValue = "{${HomeDestinationsArgs.LOCALITY_ID_ARG}}",
                newValue = localityId.toString()),
            navOptions = NavOptions.Builder().setPopUpTo(
                route = HomeDestinations.HOME_ROUTE,
                inclusive = true,
            ).build()
        )
    }

    override fun openSearchScreen() {
        navController.navigate(LocationDestinations.SEARCH_ROUTE)
    }

    override fun back() {
        navController.popBackStack()
    }
}