package com.example.franciscoalbianaapp

import androidx.room.*

@Entity(tableName="url_entity")
data class UrlEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = ""
)