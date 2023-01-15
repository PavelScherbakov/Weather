package com.pscher.weather.datastore.repository.base.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

interface ReadWrite<T> {
    val key: Preferences.Key<T>
    fun get(coroutineContext: CoroutineContext? = null): Flow<T?>
    suspend fun set(value: T)
}

class ReadWriteImpl<T>(
    val store: DataStore<Preferences>,
    override val key: Preferences.Key<T>
) : ReadWrite<T> {
    override fun get(coroutineContext: CoroutineContext?): Flow<T?> =
        store.data
            .map { it[key] }
            .apply { coroutineContext?.let { flowOn(it) } }

    override suspend fun set(value: T) {
        withContext(Dispatchers.IO) {
            store.edit { it[key] = value }
        }
    }
}
