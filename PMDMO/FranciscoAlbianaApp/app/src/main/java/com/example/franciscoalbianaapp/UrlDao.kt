package com.example.franciscoalbianaapp

import androidx.room.*

@Dao
interface UrlDao {
    @Query("SELECT * FROM urlEntity")
    suspend fun getAll(): MutableList<UrlEntity>
    @Query("SELECT * FROM urlEntity WHERE id = :id")
    suspend fun getById(id: Long): UrlEntity
    @Update
    suspend fun update(url: UrlEntity)
    @Delete
    suspend fun delete(url: UrlEntity)
    @Insert
    suspend fun insert(url: UrlEntity) : Long
}