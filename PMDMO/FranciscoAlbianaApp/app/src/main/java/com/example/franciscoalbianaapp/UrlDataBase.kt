package com.example.franciscoalbianaapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UrlEntity::class], version = 1)
abstract class UrlDataBase : RoomDatabase() {
    abstract fun urlDao(): UrlDao
}