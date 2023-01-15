package com.pscher.weather.datastore.repository.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.pscher.weather.datastore.repository.AppSettingDataStore
import com.pscher.weather.datastore.repository.base.datastore.DataStoreKey
import com.pscher.weather.datastore.repository.base.datastore.ReadWrite
import com.pscher.weather.datastore.repository.base.datastore.ReadWriteImpl
import javax.inject.Inject

val Context.appSettingDataStore: DataStore<Preferences> by preferencesDataStore(name = "appSettingDataStore")

class AppSettingDataStoreKeyImpl<T>(override val key: Preferences.Key<T>) : DataStoreKey<T> {
    override fun readWrite(context: Context): ReadWrite<T> =
        ReadWriteImpl(context.appSettingDataStore, key)
}


class AppSettingDataStoreImpl @Inject constructor(
    private val context: Context,
    //private val localityIdKey:
): AppSettingDataStore {

    //todo надо по другому сделать

    override fun currentLocalityId(): ReadWrite<Int> =
        AppSettingDataStoreKeyImpl(intPreferencesKey("current_locality_id"))
            .readWrite(context)

    override fun appDarkTheme(): ReadWrite<Boolean> =
        AppSettingDataStoreKeyImpl(booleanPreferencesKey("is_app_theme_light"))
            .readWrite(context)
}



