package com.pscher.weather.datastore.repository.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pscher.weather.datastore.repository.room.entity.LocalityEntity

@Dao
interface LocalityDao {
    @Query("SELECT * FROM locality")
    suspend fun getAll(): List<LocalityEntity>

    @Query("SELECT * FROM locality WHERE id = :localityId")
    suspend fun loadById(localityId: Int): LocalityEntity

    @Insert
    suspend fun insert(localityEntity: LocalityEntity)

    @Update
    suspend fun update(localityEntity: LocalityEntity)

    @Delete
    suspend fun delete(localityEntity: LocalityEntity)
}