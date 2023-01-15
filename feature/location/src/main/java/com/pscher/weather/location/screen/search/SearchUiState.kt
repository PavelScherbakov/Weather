package com.pscher.weather.location.screen.search

import com.pscher.weather.core.model.Locality
import com.pscher.weather.core.model.testLocality
import com.pscher.weather.core.model.testLocality2

data class SearchUiState(
    val search: String,
    val resultSearch: List<Locality>,
)

val testSearchUiState = SearchUiState(
    search = "abc",
    resultSearch = listOf(testLocality, testLocality2)
)

val testSearchUiStateEmpty = SearchUiState(
    search = "",
    resultSearch = listOf(),
)

val initialSearchUiState = SearchUiState(
    search = "",
    resultSearch = listOf(),
)





