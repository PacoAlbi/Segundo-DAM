package com.example.franciscoalbianaapp

import android.media.MediaMetadataEditor
import android.provider.MediaStore.Video.Media
import androidx.room.*

/**
 * Creo la entidad que representará mi BBDD
 */
@Entity(tableName="SoundsEntity")
data class SoundsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var tiempo: Long,

)