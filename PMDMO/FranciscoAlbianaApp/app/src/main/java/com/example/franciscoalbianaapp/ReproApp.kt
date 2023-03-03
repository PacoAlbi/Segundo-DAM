package com.example.franciscoalbianaapp

import android.app.Application
import androidx.room.Room

class ReproApp : Application() {

    companion object{
        lateinit var database: SoundsDataBase
    }

override fun onCreate() {

        super.onCreate()
        //Inicializo la BBDD
        database = Room.databaseBuilder(this, SoundsDataBase::class.java, "SoundsDataBase").build();
    }


}