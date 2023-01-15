package com.pscher.weather.datastore.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pscher.weather.datastore.repository.room.dao.LocalityDao
import com.pscher.weather.datastore.repository.room.entity.LocalityEntity

@Database(entities = [LocalityEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase(), AppDatabaseContract

interface AppDatabaseContract {
    fun localityDao(): LocalityDao
}