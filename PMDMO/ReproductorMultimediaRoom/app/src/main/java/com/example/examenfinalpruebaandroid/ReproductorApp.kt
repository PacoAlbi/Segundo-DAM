package com.example.examenfinalpruebaandroid

import android.app.Application
import androidx.room.Room

class ReproductorApp : Application() {
    companion object{
        lateinit var database : UrlDataBase
    }

    override fun onCreate() {
        super.onCreate()
        database =
            Room.databaseBuilder(
                this,
                UrlDataBase::class.java,
                "url-db"
            ).build()
    }
}