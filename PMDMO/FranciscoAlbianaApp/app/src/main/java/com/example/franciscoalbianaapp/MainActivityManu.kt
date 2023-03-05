//package com.example.examenrecovery
//
//import android.media.MediaPlayer
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import kotlinx.coroutines.delay
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.runBlocking
//
//class MainActivity : AppCompatActivity() {
//
//    lateinit var secuenciaSonidos: MutableList<SonidoEntity>
//    private lateinit var binding: ActivityMainBinding
//    private var estaGrabando = false
//    lateinit var mediaPlayer: MediaPlayer
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // inicializo la secuencia de sonidos
//        secuenciaSonidos = ArrayList()
//
//        binding.btnGrabar.setOnClickListener {
//
//            // limpiamos la secuencia de sonidos
//            secuenciaSonidos.clear()
//
//            if(estaGrabando == false){
//                estaGrabando = true
//            }else{
//                estaGrabando = false
//            }
//        }
//
//        binding.btnReproducir.setOnClickListener {
//
//            // volvemos a poner el booleano a falso para que pueda grabar otra vez
//            estaGrabando = false
//
//            // desactivo los botones para que no se puedan usar mientras se reproducen los sonidos
//            binding.btnSonido1.isClickable = false
//            binding.btnSonido2.isClickable = false
//            binding.btnSonido3.isClickable = false
//            binding.btnSonido4.isClickable = false
//
//            reproducirSonidos()
//
//        }
//
//        binding.btnSonido1.setOnClickListener {
//
//            // reproducimos el sonido fuera del if para que suene igualmente aunque no se grabe
//            reproducirSonido1()
//
//            // si esta grabando se almacena el sonido
//            if(estaGrabando){
//                almacenarSonido(SonidoEntity(sonido = 1))
//            }
//
//        }
//
//        binding.btnSonido2.setOnClickListener {
//
//            // reproducimos el sonido fuera del if para que suene igualmente aunque no se grabe
//            reproducirSonido2()
//
//            // si esta grabando se almacena el sonido
//            if(estaGrabando){
//                almacenarSonido(SonidoEntity(sonido = 2))
//            }
//        }
//
//        binding.btnSonido3.setOnClickListener {
//
//            // reproducimos el sonido fuera del if para que suene igualmente aunque no se grabe
//            reproducirSonido3()
//
//            // si esta grabando se almacena el sonido
//            if(estaGrabando){
//                almacenarSonido(SonidoEntity(sonido = 3))
//            }
//        }
//
//        binding.btnSonido4.setOnClickListener {
//
//            // reproducimos el sonido fuera del if para que suene igualmente aunque no se grabe
//            reproducirSonido4()
//
//            // si esta grabando se almacena el sonido
//            if(estaGrabando){
//                almacenarSonido(SonidoEntity(sonido = 4))
//            }
//        }
//
//    }
//
//    /**
//     * Metodo para almacenar un sonido en la base de datos local usando Room y obteniendo el sonido lo añadimos a una lista
//     */
//    private fun almacenarSonido(snd: SonidoEntity) = runBlocking {
//        launch {
//            val id = SonidoApp.database.sonidoDao().addSonido(snd) // añado el sonido a la base de datos
//            val recoverySound = SonidoApp.database.sonidoDao().getSonidoById(id) // obtengo el sonido
//            secuenciaSonidos.add(recoverySound) // añado a la lista
//        }
//
//    }
//
//    /**
//     * Metodo que recorre la lista de todos los sonidos que hayamos pulsado en los botones, activa los botones de nuevo una vez acabe de reproducir los sonidos
//     */
//    private fun reproducirSonidos(){
//
//        for(sonidoEntity in secuenciaSonidos){
//
//            when(sonidoEntity.sonido){
//
//                1 ->
//                {
//                    reproducirSonido1()
//                }
//                2 ->
//                {
//                    reproducirSonido2()
//                }
//                3 ->
//                {
//                    reproducirSonido3()
//                }
//                4 ->
//                {
//                    reproducirSonido4()
//                }
//            }
//
//            runBlocking { launch { delay(300) } }
//        }
//
//        binding.btnSonido1.isClickable = true
//        binding.btnSonido2.isClickable = true
//        binding.btnSonido3.isClickable = true
//        binding.btnSonido4.isClickable = true
//    }
//
//    /**
//     * Metodo para reproducir el sonido basico 1 con la clase MediaPlayer
//     */
//    private fun reproducirSonido1(){
//
//        mediaPlayer = MediaPlayer.create(this, R.raw.cl_hat) // creo el mediaplayer
//        mediaPlayer.start() // para que suene
//
//    }
//
//    /**
//     * Metodo para reproducir el sonido basico 2 con la clase MediaPlayer
//     */
//    private fun reproducirSonido2(){
//
//        mediaPlayer = MediaPlayer.create(this, R.raw.hihat1) // creo el mediaplayer
//        mediaPlayer.start() // para que suene
//
//    }
//
//    /**
//     * Metodo para reproducir el sonido basico 3 con la clase MediaPlayer
//     */
//    private fun reproducirSonido3(){
//
//        mediaPlayer = MediaPlayer.create(this, R.raw.kick) // creo el mediaplayer
//        mediaPlayer.start() // para que suene
//
//    }
//
//    /**
//     * Metodo para reproducir el sonido basico 4 con la clase MediaPlayer
//     */
//    private fun reproducirSonido4(){
//
//        mediaPlayer = MediaPlayer.create(this, R.raw.snare) // creo el mediaplayer
//        mediaPlayer.start() // para que suene
//
//    }
//}