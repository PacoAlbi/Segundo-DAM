package com.example.franciscoalbianaapp

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Creo la clase que será la BBDD
 */
@Database(entities = [SoundsEntity::class], version = 1)
abstract class SoundsDataBase : RoomDatabase() {
    abstract fun SoundsDao(): SoundsDao
}