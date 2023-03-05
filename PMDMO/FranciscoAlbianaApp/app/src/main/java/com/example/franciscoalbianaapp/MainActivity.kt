package com.example.franciscoalbianaapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.franciscoalbianaapp.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    //Preparo las variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var listaSonidos: MutableList<SoundsEntity>
    private var grabando = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicio la lista
        listaSonidos = ArrayList()
        //Saco el bindeo del main para poder usarlo
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Bindeo los botones que reproduciran los sonidos
        binding.btn1.setOnClickListener { reproducirSonido1() }
        binding.btn2.setOnClickListener { reproducirSonido2() }
        binding.btn3.setOnClickListener { reproducirSonido3() }
        binding.btn4.setOnClickListener { reproducirSonido4() }
        binding.btnGrabar.setOnClickListener { grabando() }
        binding.btnReproducir.setOnClickListener { reproducir() }

    }

    /**
     * Precondiciones: No tiene
     * Método para reproducir el primero sonido
     * Postcondiciones: No tiene
     */
    fun reproducirSonido1(){
        mediaPlayer = MediaPlayer.create(this, R.raw.crash)
        mediaPlayer.start()
        if (grabando){
            grabar(SoundsEntity(sonido = 1))
        }
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
        if (grabando){
            grabar(SoundsEntity(sonido = 2))
        }
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
        if (grabando){
            grabar(SoundsEntity(sonido = 3))
        }
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
        if (grabando){
            grabar(SoundsEntity(sonido = 4))
        }
        Toast.makeText(this, "Sonando 4", Toast.LENGTH_SHORT).show()
    }
    fun grabando(){
        grabando = true
        Toast.makeText(this, "Grabando secuencia", Toast.LENGTH_LONG).show()
    }
    /**
     * Precondiciones: No tiene
     * Método para grabar la secuencia de sonidos
     * Como no se que archivo pasarle, no puedo añadirlo a la BBDD
     * Postcondiciones: No tiene
     */
    fun grabar (sonido : SoundsEntity) = runBlocking {
//        launch {
//            ReproApp.database.clearAllTables()
//        }
        launch {
            ReproApp.database.SoundsDao().insert(sonido)
        }
    }
    /**
     * Precondiciones: No tiene
     * Método para reproducir la secuencia de sonidos
     * Sin nada grabado no puedo reproducor nada.
     * Postcondiciones: No tiene
     */
    fun reproducir () = runBlocking {
        grabando = false
        launch {
            listaSonidos = ReproApp.database.SoundsDao().getAll()
            reproducirSonidos()
        }
    }
    /**
     * Precondiciones: No tiene
     * Método para reproducir la secuencia de sonidos
     * Postcondiciones: No tiene
     */
    fun reproducirSonidos(){
        Toast.makeText(this, "Reproduciendo secuencia", Toast.LENGTH_LONG).show()
        for(sonido in listaSonidos){
            when(sonido.sonido){
                1 -> { reproducirSonido1() }
                2 -> { reproducirSonido2() }
                3 -> { reproducirSonido3() }
                4 -> { reproducirSonido4() }
            }
            runBlocking { launch { delay(300) } }
        }
    }
}