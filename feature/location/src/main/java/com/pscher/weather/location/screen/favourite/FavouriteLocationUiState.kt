package com.pscher.weather.location.screen.favourite

import com.pscher.weather.core.model.Locality
import com.pscher.weather.core.model.testLocality
import com.pscher.weather.core.model.testLocality2

data class FavouriteLocationUiState(
    val favouriteList: List<Locality>,
)

val testFavouriteLocationUiState = FavouriteLocationUiState(
    favouriteList = listOf(testLocality, testLocality2)
)

val defaultFavouriteLocationUiState = FavouriteLocationUiState(
    favouriteList = listOf()
)

