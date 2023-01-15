package com.pscher.weather.home

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pscher.weather.home.screen.HomeScreen
import com.pscher.weather.home.screen.HomeVM
import com.pscher.weather.homeapi.HomeDestinations
import com.pscher.weather.homeapi.HomeDestinationsArgs.LOCALITY_ID_ARG
import com.pscher.weather.homeapi.HomeNavGraph
import com.pscher.weather.homeapi.HomeNavigationActions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
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
        composable(
            route = HomeDestinations.HOME_ROUTE,
            arguments = listOf(
                navArgument(LOCALITY_ID_ARG) { type = NavType.IntType; defaultValue = -1},
            )
        ) { entry ->
            val localityId = entry.arguments?.getInt(LOCALITY_ID_ARG) ?: -1
            val scope: CoroutineScope = rememberCoroutineScope()
            LaunchedEffect(Unit) {
                scope.launch {
                    homeVM.setCurrentLocality(localityId)
                }
            }

            HomeScreen(
                uiState = homeVM.homeUiState.collectAsState().value,
                updateForecast =  { homeVM.updateForecast() },
                onClickFavourite = { navigationActions.openFavouriteLocationScreen() },
                onClickSetting = { navigationActions.openSettingScreen() }
            )
        }
    }
}