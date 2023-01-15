package com.pscher.weather.datastore.di

import android.content.Context
import androidx.room.Room
import com.pscher.weather.coreapi.di.AppContext
import com.pscher.weather.coreapi.di.AppScope
import com.pscher.weather.datastore.repository.AppDataRepository
import com.pscher.weather.datastore.repository.AppDataRepositoryImpl
import com.pscher.weather.datastore.repository.AppSettingDataStore
import com.pscher.weather.datastore.repository.pref.AppSettingDataStoreImpl
import com.pscher.weather.datastore.repository.room.AppDatabase
import com.pscher.weather.datastore.repository.room.AppDatabaseContract
import com.pscher.weather.datastore.repository.room.dao.LocalityDao
import dagger.Module
import dagger.Provides
import dagger.Reusable

private const val APP_DATABASE_NAME = "APP_DB"

@Module
interface DataStoreModule {
    companion object{
        @Provides
        @AppScope
        fun provideAppSettingDataStore(
            @AppContext context: Context,
        ): AppSettingDataStore {
            return AppSettingDataStoreImpl(context)
        }

        @Provides
        @AppScope
        fun provideDataStoreRepository(
            appSettingDataStore: AppSettingDataStore,
            localityDao: LocalityDao,
        ): AppDataRepository {
            return AppDataRepositoryImpl(appSettingDataStore, localityDao)
        }


        @Provides
        @Reusable
        fun provideLocalityDao(appDatabaseContract: AppDatabaseContract): LocalityDao {
            return appDatabaseContract.localityDao()
        }

        @Provides
        @AppScope
        fun provideAppDatabase(
            @AppContext context: Context
        ): AppDatabaseContract {
            val db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, APP_DATABASE_NAME
            ).build()
            return db
        }
    }

    /*@Binds
    fun bindGeoRepository(repository: AppDataRepositoryImpl): AppDataRepository*/
}

/*
@Qualifier
annotation class DataStoreRepository*/
