package com.example.examenfinalpruebaandroid

import androidx.room.*

@Dao
interface UrlDao
{
    @Query("SELECT * FROM url_entity")
    suspend fun getAll() : MutableList<UrlEntity>
    @Query("Select * From url_entity Where id =:id")
    suspend fun getUrlById(id:Long) : UrlEntity



    @Update
    suspend fun updateUrl(url:UrlEntity)
    @Delete
    suspend fun deleteUrl(url : UrlEntity)
    @Insert
    suspend fun addUrl(url : UrlEntity) : Long
}