package com.pscher.weather.navigation

import androidx.compose.material.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pscher.weather.navigationapi.MainNavigationActions
import com.pscher.weather.navigationapi.Router
import kotlinx.coroutines.CoroutineScope

class RouterImpl: Router {

    @Composable
    override fun setMainNavGraph(
        modifier: Modifier,
        navController: NavHostController,
        coroutineScope: CoroutineScope,
        drawerState: DrawerState,
        startDestination: String,
        navActions: MainNavigationActions
    ) {
        MainNavGraph(
            modifier = modifier,
            navController = navController,
            coroutineScope = coroutineScope,
            drawerState = drawerState,
            startDestination = startDestination,
            navActions = navActions,
        )
    }

}