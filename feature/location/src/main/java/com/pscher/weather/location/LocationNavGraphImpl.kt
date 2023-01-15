package com.pscher.weather.location

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pscher.weather.location.screen.favourite.FavouriteLocationScreen
import com.pscher.weather.location.screen.favourite.FavouriteLocationVM
import com.pscher.weather.location.screen.search.SearchScreen
import com.pscher.weather.location.screen.search.SearchVM
import com.pscher.weather.locationapi.LocationDestinations
import com.pscher.weather.locationapi.LocationNavGraph
import com.pscher.weather.locationapi.LocationNavigationActions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class LocationNavGraphImpl @Inject constructor(
    private val favouriteLocationVM: FavouriteLocationVM,
    private val searchVM: SearchVM,
): LocationNavGraph {

    init {
        Timber.e("Create LocationNavGraphImpl")
    }

    override fun NavGraphBuilder.addLocationNavGraph(navigationActions: LocationNavigationActions) {
        composable(LocationDestinations.FAVOURITE_LOCATION_ROUTE) {
            val scope: CoroutineScope = rememberCoroutineScope()
            LaunchedEffect(Unit) {
                scope.launch { favouriteLocationVM.updateFavouriteList() }
            }
            FavouriteLocationScreen(
                uiState = favouriteLocationVM.favouriteUiState.collectAsState().value,
                onClickBack = { navigationActions.back() },
                onClickSearch = {
                    searchVM.cleanSearch()
                    navigationActions.openSearchScreen()
                },
                onClickFavourite = { navigationActions.openHomeScreen(it.id) },
            )
        }

        composable(LocationDestinations.SEARCH_ROUTE) {
            val scope: CoroutineScope = rememberCoroutineScope()
            SearchScreen(
                uiState = searchVM.searchUiState.collectAsState().value,
                onClickBack = { navigationActions.back() },
                onSearch = { searchVM.search(it) },
                onClickItem = {
                    scope.launch {
                        searchVM.saveLocality(it)
                        navigationActions.openHomeScreen(it.id)
                    }
                },
            )
        }
    }
}