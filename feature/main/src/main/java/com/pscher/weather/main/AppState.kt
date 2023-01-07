package com.pscher.weather.main

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController

@Stable
class AppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
) {

}