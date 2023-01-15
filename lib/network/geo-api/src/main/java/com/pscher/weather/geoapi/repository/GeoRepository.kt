package com.pscher.weather.geoapi.repository

import com.pscher.weather.core.model.Locality
import com.pscher.weather.geoapi.repository.api.GeoApi
import javax.inject.Inject


interface GeoRepository {
    suspend fun search(
        search: String,
    ): List<Locality>
}

class GeoRepositoryImpl @Inject constructor(
    private val geoApi: GeoApi,
): GeoRepository {

    override suspend fun search(search: String): List<Locality> {
        return geoApi.search(name = search).results ?: listOf()
    }
}