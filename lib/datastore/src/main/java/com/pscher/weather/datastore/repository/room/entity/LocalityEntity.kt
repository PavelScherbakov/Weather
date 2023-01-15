package com.pscher.weather.datastore.repository.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pscher.weather.core.model.Locality

@Entity(tableName = "locality")
data class LocalityEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "latitude") val latitude: Float,
    @ColumnInfo(name = "longitude") val longitude: Float,
    @ColumnInfo(name = "country_id") val countryId: Int,
    @ColumnInfo(name = "country") val country: String?,
)

fun LocalityEntity.toLocality(): Locality =
    Locality(
        id = this.id,
        name = this.name,
        latitude = this.latitude,
        longitude = this.longitude,
        country = this.country,
        countryId = this.countryId,
    )

fun localityToLocalityEntity(locality: Locality): LocalityEntity =
    LocalityEntity(
        id = locality.id,
        name = locality.name,
        latitude = locality.latitude,
        longitude = locality.longitude,
        countryId = locality.countryId,
        country = locality.country,
    )