package com.pscher.weather.home.screen

data class HomeUiState(
    val title: String,
    val temperature: String,
)


val testHomeUiState = HomeUiState(
    title = "HomeScreenTest",
    temperature = "-",
)

val defaultHomeUiState = HomeUiState(
    title = "HomeScreenDefault",
    temperature = "-",
)
