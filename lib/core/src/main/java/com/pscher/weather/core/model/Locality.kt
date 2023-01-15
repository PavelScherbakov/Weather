package com.pscher.weather.core.model

import com.google.gson.annotations.SerializedName

data class Locality(
    val id: Int,
    val name: String,
    val latitude: Float,
    val longitude: Float,
    @SerializedName("country_id")
    val countryId: Int,
    val country: String?,
)

val testLocality = Locality(
    id = 1,
    name = "Псков",
    latitude = 57.81f,
    longitude = 28.35f,
    country = "Russia",
    countryId = 1,
)

val testLocality2 = Locality(
    id = 2,
    name = "Москва",
    latitude = 57.81f,
    longitude = 28.35f,
    country = "Russia",
    countryId = 1,
)

val defaultLocality = Locality(
    id = -1,
    name = "",
    latitude = 0f,
    longitude = 0f,
    country = "",
    countryId = -1,
)
