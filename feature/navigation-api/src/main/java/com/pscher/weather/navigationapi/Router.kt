package com.pscher.weather.navigationapi

import androidx.compose.material.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pscher.weather.navigationapi.MainNavigationActions
import kotlinx.coroutines.CoroutineScope

interface Router {

    @Composable
    fun setMainNavGraph(
        modifier: Modifier,
        navController: NavHostController,
        coroutineScope: CoroutineScope,
        drawerState: DrawerState,
        startDestination: String,
        navActions: MainNavigationActions,
    )

}