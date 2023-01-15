package com.pscher.weather.location.screen.search

import android.database.sqlite.SQLiteConstraintException
import com.pscher.weather.core.model.Locality
import com.pscher.weather.datastore.repository.AppDataRepository
import com.pscher.weather.datastore.repository.room.entity.localityToLocalityEntity
import com.pscher.weather.geoapi.repository.GeoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import timber.log.Timber
import javax.inject.Inject


class SearchVM @Inject constructor(
    private val geoRepository: GeoRepository,
    private val appDataRepository: AppDataRepository,
) {

    init {
        Timber.e("Create SearchVM")
    }

    private val _searchUiState = MutableStateFlow(initialSearchUiState)
    val searchUiState: StateFlow<SearchUiState> = _searchUiState.asStateFlow()

    private val minSearchLength = 2

    suspend fun search(search: String?) {
        Timber.e("SearchVM search search = $search")

        _searchUiState.update { searchUiState ->
            searchUiState.copy(
                search = search ?: "",
            )
        }

        val response = if (search.isNullOrEmpty() || search.length < minSearchLength) listOf()
        else geoRepository.search(
            search = search,
        )

        Timber.e("SearchVM search response = $response")

        _searchUiState.update { searchUiState ->
            searchUiState.copy(
                resultSearch = response
            )
        }
    }

    suspend fun saveLocality(locality: Locality) {
        appDataRepository.appSettingDataStore().currentLocalityId().set(locality.id)
        try {
            appDataRepository.localityDao().insert(localityToLocalityEntity(locality))
        } catch (e: SQLiteConstraintException) {
            appDataRepository.localityDao().update(localityToLocalityEntity(locality))
        }
    }

    fun cleanSearch() {
        _searchUiState.update { initialSearchUiState }
    }
}