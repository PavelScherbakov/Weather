package com.pscher.weather.geoapi.repository.api

import com.pscher.weather.geoapi.repository.response.SearchResp
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface GeoApi {

    /**
     * Search for cities or postal code
     */
    @GET("/v1/search")
    suspend fun search(
        @Query("name") name: String,
        @Query("count") count: Int = 10,
        @Query("format") format: String = "json",
        @Query("language") language: String = "ru",
    ): SearchResp
}