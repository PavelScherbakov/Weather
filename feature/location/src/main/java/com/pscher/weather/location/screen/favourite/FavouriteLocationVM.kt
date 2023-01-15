package com.pscher.weather.location.screen.favourite

import com.pscher.weather.datastore.repository.AppDataRepository
import com.pscher.weather.datastore.repository.room.entity.toLocality
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject

class FavouriteLocationVM @Inject constructor(
    private val appDataRepository: AppDataRepository,
) {

    init {
        Timber.e("Create FavouriteLocationVM")
    }

    private val _favouriteUiState = MutableStateFlow(defaultFavouriteLocationUiState)
    val favouriteUiState: StateFlow<FavouriteLocationUiState> = _favouriteUiState.asStateFlow()

    suspend fun updateFavouriteList() {
        Timber.e("FavouriteLocationVM updateFavouriteList")

        val favouriteList = appDataRepository.localityDao().getAll().map { it.toLocality() }

        _favouriteUiState.update { favouriteLocationUiState ->
            favouriteLocationUiState.copy(
                favouriteList = favouriteList
            )
        }
    }
}