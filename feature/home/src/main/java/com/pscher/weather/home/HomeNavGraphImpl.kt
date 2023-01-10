package com.pscher.weather.home

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pscher.weather.home.screen.HomeScreen
import com.pscher.weather.home.screen.HomeVM
import com.pscher.weather.homeapi.HomeDestinations
import com.pscher.weather.homeapi.HomeNavGraph
import com.pscher.weather.homeapi.HomeNavigationActions
import timber.log.Timber
import javax.inject.Inject

class HomeNavGraphImpl
@Inject constructor(
    private val homeVM: HomeVM,
): HomeNavGraph {

    init {
        Timber.e("Create HomeNavGraphImpl")
    }

    override fun NavGraphBuilder.addHomeNavGraph(
        navigationActions: HomeNavigationActions,
    ) {
        composable(HomeDestinations.HOME_ROUTE) {
            //val uiState by homeVM.homeUiState.collectAsState()
            HomeScreen(
                uiState = homeVM.homeUiState.collectAsState().value,
                onClickFavourite = { navigationActions.openFavouriteLocationScreen() },
                updateForecast =  { homeVM.updateForecast() }
            )
        }
    }
}