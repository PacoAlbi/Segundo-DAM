package com.example.franciscoalbianaapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.room.Room
import com.example.franciscoalbianaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Preparo las variables para
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Saco el bindeo del main para poder usarlo
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Bindeo los botones que reproduciran los sonidos
        binding.btn1.setOnClickListener { reproducirSonido1() }
        binding.btn2.setOnClickListener { reproducirSonido2() }
        binding.btn3.setOnClickListener { reproducirSonido3() }
        binding.btn4.setOnClickListener { reproducirSonido4() }


    }

    /**
     * Precondiciones: No tiene
     * Método para reproducir el primero sonido
     * Postcondiciones: No tiene
     */
    fun reproducirSonido1(){
        mediaPlayer = MediaPlayer.create(this, R.raw.crash)
        mediaPlayer.start()
        Toast.makeText(this, "Sonando 1", Toast.LENGTH_SHORT).show()
    }
    /**
     * Precondiciones: No tiene
     * Método para reproducir el segundo sonido
     * Postcondiciones: No tiene
     */
    fun reproducirSonido2(){
        mediaPlayer = MediaPlayer.create(this, R.raw.snare)
        mediaPlayer.start()
        Toast.makeText(this, "Sonando 2", Toast.LENGTH_SHORT).show()
    }
    /**
     * Precondiciones: No tiene
     * Método para reproducir el tercer sonido
     * Postcondiciones: No tiene
     */
    fun reproducirSonido3(){
        mediaPlayer = MediaPlayer.create(this, R.raw.kick2)
        mediaPlayer.start()
        Toast.makeText(this, "Sonando 3", Toast.LENGTH_SHORT).show()
    }
    /**
     * Precondiciones: No tiene
     * Método para reproducir el cuarto sonido
     * Postcondiciones: No tiene
     */
    fun reproducirSonido4(){
        mediaPlayer = MediaPlayer.create(this, R.raw.cowbell)
        mediaPlayer.start()
        Toast.makeText(this, "Sonando 4", Toast.LENGTH_SHORT).show()
    }
    /**
     * Precondiciones: No tiene
     * Método para grabar la secuencia de sonidos
     * Como no se que archivo pasarle, no puedo añadirlo a la BBDD
     * Postcondiciones: No tiene
     */
    fun grabar (){
        //val room: SoundsDataBase = Room.databaseBuilder(this, SoundsDataBase::class.java, "Sonidos").build()
        //room.SoundsDao().insert(mediaPlayer)
        Toast.makeText(this, "Grabando secuencia", Toast.LENGTH_LONG).show()
    }
    /**
     * Precondiciones: No tiene
     * Método para reproducir la secuencia de sonidos
     * Sin nada grabado no puedo reproducor nada.
     * Postcondiciones: No tiene
     */
    suspend fun reproducir () {
        var room = Room.databaseBuilder(this, SoundsDataBase::class.java, "Sonidos").build()
        var sonidos = room.SoundsDao().getAll()
        //mediaPlayer = MediaPlayer.create(this, sonidos)
        mediaPlayer.start()
        Toast.makeText(this, "Reproduciendo secuencia", Toast.LENGTH_LONG).show()
    }
}