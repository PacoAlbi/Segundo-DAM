package com.example.franciscoalbianaapp

import androidx.room.*

/**
 * Preparo el Data Access Object para acceder a los métodos de la Room
 */
@Dao
interface SoundsDao {
    @Query("SELECT * FROM SoundsEntity")
    suspend fun getAll(): MutableList<SoundsEntity>
    @Query("SELECT * FROM SoundsEntity WHERE id = :id")
    suspend fun getById(id: Long): SoundsEntity
    @Update
    suspend fun update(sound: SoundsEntity)
    @Delete
    suspend fun delete(sound: SoundsEntity)
    @Insert
    suspend fun insert(sound: SoundsEntity) : Long
}