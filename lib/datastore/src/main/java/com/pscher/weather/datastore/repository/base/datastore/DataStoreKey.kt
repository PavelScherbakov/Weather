package com.pscher.weather.datastore.repository.base.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences

interface DataStoreKey<T> {
    val key: Preferences.Key<T>
    fun readWrite(context: Context): ReadWrite<T>
}