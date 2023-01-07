package com.pscher.weather.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pscher.weather.ui.uikit.AppTheme

@Composable
fun App(
    context: @Composable (PaddingValues) -> Unit,
) {
    AppTheme {
        //val appState = rememberAppState()
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            bottomBar = {
                /*if (appState.shouldShowBottomBar) {
                    BottomBar(
                        tabs = appState.bottomBarTabs,
                        currentRoute = appState.currentRoute!!,
                        navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }*/
            },
            scaffoldState = scaffoldState
        ) { paddingValues ->
            context(paddingValues)
        }
    }
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController()
) =
    remember(scaffoldState, navController) {
        AppState(scaffoldState, navController)
    }






