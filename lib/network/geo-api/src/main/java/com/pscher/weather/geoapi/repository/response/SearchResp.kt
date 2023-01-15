package com.pscher.weather.geoapi.repository.response

import com.pscher.weather.core.model.Locality

data class SearchResp(
    val results: List<Locality>?
)