package com.pscher.weather.datastore.repository

import com.pscher.weather.coreapi.di.AppContext
import com.pscher.weather.datastore.repository.base.pref.ReadWrite
import com.pscher.weather.datastore.repository.room.dao.LocalityDao
import javax.inject.Inject

interface AppDataRepository {
    fun appSettingDataStore(): AppSettingDataStore
    fun localityDao(): LocalityDao
}

interface AppSettingDataStore {
    fun currentLocalityId(): ReadWrite<Int>
    fun appDarkTheme(): ReadWrite<Boolean>
}

class AppDataRepositoryImpl @Inject constructor(
    private val appSettingDataStore: AppSettingDataStore,
    private val localityDao: LocalityDao,
): AppDataRepository {
    override fun appSettingDataStore(): AppSettingDataStore {
        return appSettingDataStore
    }

    override fun localityDao(): LocalityDao {
        return localityDao
    }
}


