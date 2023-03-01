package com.example.tareamultimedia

import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import com.example.tareamultimedia.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var mediaController: MediaController
    private lateinit var mediaController2: MediaController
    private var posicionVideo1 = 0
    private var posicionVideo2 = 0
    private var mediaPlayer1: MediaPlayer? = null
    private var mediaPlayer2: MediaPlayer? = null
    private val audioUrl1 = "https://ak.picdn.net/shutterstock/audio/488861/preview/preview.mp3"
    private val audioUrl2 = "https://ak.picdn.net/shutterstock/audio/506950/preview/preview.mp3"
    private val videoUrl = "http://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4"
    private val videoUrl2 = "https://player.vimeo.com/external/543336369.sd.mp4?s=bd2b2c4243c298dac58aa16535ca942499157c5c&profile_id=164&oauth2_token_id=57447761"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer1 = MediaPlayer()
        mediaPlayer1!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer1!!.setDataSource(audioUrl1)
        mediaPlayer1!!.prepare()

        mediaPlayer2 = MediaPlayer()
        mediaPlayer2!!.setAudioStreamType(AudioManager.STREAM_MUSIC)
        mediaPlayer2!!.setDataSource(audioUrl2)
        mediaPlayer2!!.prepare()

        binding.btnPlay1.setOnClickListener {

            if(binding.videoView.isPlaying || binding.videoView2.isPlaying){
                pausarVideo1()
                pausarVideo2()
            }

            // compruebo si el audio 1 esta sonando para que al reproducir el audio 2 se resetee el audio 1
            if (mediaPlayer2!!.isPlaying) {
                resetAudio2() // reseteo el audio 1
                binding.btnPlay2.text = "Audio 2" // y cambiamos el nombre del boton
            }

            // si al pulsar el boton el audio 1 esta sonando, se pausara y cambiara el nombre del boton, si no esta sonando se pausaran los videos, empezara a reproducirse y cambiara el nombre del boton
            if (mediaPlayer1!!.isPlaying) {

                pausarVideo1() // pauso los videos
                pausarVideo2()
                pausarAudio1() // se pausa el audio 1
                binding.btnPlay1.text = "REANUDAR" // cambio el nombre del boton cuando este pausado
            } else {

                try {

                    reproducirAudio1() // se reproduce el audio 1
                    binding.btnPlay1.text = "PAUSAR" // cambio el nombre del boton cuando se este reproduciendo
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
        }

        binding.btnPlay2.setOnClickListener {

            if(binding.videoView.isPlaying || binding.videoView2.isPlaying){
                pausarVideo1()
                pausarVideo2()
            }

            // compruebo si el audio 1 esta sonando para que al reproducir el audio 2 se resetee el audio 1
            if (mediaPlayer1!!.isPlaying) {
                resetAudio1() // reseteo el audio 1
                binding.btnPlay1.text = "Audio 1" // y cambiamos el nombre del boton
            }

            // si al pulsar el boton el audio 2 esta sonando, se pausara y cambiara el nombre del boton, si no esta sonando se pausaran los videos, empezara a reproducirse y cambiara el nombre del boton
            if (mediaPlayer2!!.isPlaying) {

                pausarVideo1() // pauso los videos
                pausarVideo2()
                pausarAudio2() // se pausa el audio 2
                binding.btnPlay2.text = "REANUDAR" // cambio el nombre del boton cuando este pausado
            } else {
                try {

                    reproducirAudio2() // se reproduce el audio 2
                    binding.btnPlay2.text = "PAUSAR" // cambio el nombre del boton cuando se este reproduciendo
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }

        }

        binding.btnReset1.setOnClickListener {

            // cuando se pulse el boton de resetear el audio 1
            resetAudio1() // se resetea el audio 1
            binding.btnPlay1.text = "Audio 1" // y le cambia el nombre al boton
            Toast.makeText(this, "AUDIO 1 RESETEADO", Toast.LENGTH_LONG).show()

        }

        binding.btnReset2.setOnClickListener {

            // cuando se pulse el boton de resetear el audio 2
            resetAudio2() // se resetea el audio 1
            binding.btnPlay2.text = "Audio 2" // y le cambia el nombre al boton

            Toast.makeText(this, "AUDIO 2 RESETEADO", Toast.LENGTH_LONG).show()

        }

        reproducirVideo1()

        reproducirVideo2()
    }

    override fun onStart() {
        super.onStart()

        binding.videoView.setVideoURI(Uri.parse(videoUrl))
        binding.barraProgreso.visibility = View.VISIBLE

        binding.videoView2.setVideoURI(Uri.parse(videoUrl2))
        binding.barraProgreso2.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()

        pausarVideo1()
        pausarVideo2()
    }

    override fun onStop() {

        binding.videoView.stopPlayback()
        binding.videoView2.stopPlayback()
        super.onStop()
    }

    /**
     * Metodo para reproducir el audio 1
     */
    fun reproducirAudio1() {

        mediaPlayer1!!.setVolume(100F, 100F)
        mediaPlayer1!!.start() // inicia el audio
        Toast.makeText(this, "REPRODUCIENDO AUDIO 1", Toast.LENGTH_LONG).show()
    }

    /**
     * Metodo para pausar el audio 1
     */
    fun pausarAudio1() {
        val pos = mediaPlayer1!!.currentPosition // para guardar la posicion actual del audio
        mediaPlayer1!!.pause() // lo pauso
        mediaPlayer1!!.seekTo(pos) // y le digo que vaya hasta la posicion que he guardado antes de pausarlo para que al volver a reproducirlo continue desde donde se habia pausado

        Toast.makeText(this, "AUDIO 1 PAUSADO", Toast.LENGTH_LONG).show()
    }

    /**
     * Metodo para reproducir el audio 2
     */
    fun reproducirAudio2() {

        mediaPlayer2!!.setVolume(100F, 100F)
        mediaPlayer2!!.start() // inicia el audio
        Toast.makeText(this, "REPRODUCIENDO AUDIO 2", Toast.LENGTH_LONG).show()
    }

    /**
     * Metodo para pausar el audio 2
     */
    fun pausarAudio2() {

        val pos = mediaPlayer2!!.currentPosition // para guardar la posicion actual del audio
        mediaPlayer2!!.pause() // lo pauso
        mediaPlayer2!!.seekTo(pos) // y le digo que vaya hasta la posicion que he guardado antes de pausarlo para que al volver a reproducirlo continue desde donde se habia pausado

        Toast.makeText(this, "AUDIO 2 PAUSADO", Toast.LENGTH_LONG).show()
    }

    /**
     * Metodo para resetear el audio 1
     */
    fun resetAudio1() {

        mediaPlayer1!!.pause() // para pausar el audio
        mediaPlayer1!!.seekTo(0) // para hacer que empiece de 0
    }

    /**
     * Metodo para resetear el audio 2
     */
    fun resetAudio2() {

        mediaPlayer2!!.pause() // para pausar el audio
        mediaPlayer2!!.seekTo(0) // para hacer que empiece de 0
    }

    /**
     * Metodo para reproducir el video 1
     */
    fun reproducirVideo1() {
        mediaController = MediaController(this)

        binding.videoView.setOnPreparedListener {
            mediaController.setAnchorView(binding.frameVideo)
            binding.videoView.setMediaController(mediaController) // para settear el mediacontroller del video 1
            binding.videoView.seekTo(posicionVideo1) // la posicion del video va hacia el entero posicionVideo1, que esta inicializado en 0 para que empiece desde el principio
            binding.videoView.start() // inicia el video 1
        }

        binding.videoView.setOnInfoListener { mediaPlayer, what, extras ->

            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                binding.barraProgreso.visibility = View.INVISIBLE
            true
        }
    }

    /**
     * Metodo para reproducir el video 2
     */
    fun reproducirVideo2() {
        mediaController2 = MediaController(this)

        binding.videoView2.setOnPreparedListener {
            mediaController.setAnchorView(binding.frameVideo2)
            binding.videoView2.setMediaController(mediaController) // para settear el mediacontroller del video 2
            binding.videoView2.seekTo(posicionVideo2) // la posicion del video va hacia el entero posicionVideo2, que esta inicializado en 0 para que empiece desde el principio
            binding.videoView2.start() // inicia el video 2
        }

        binding.videoView2.setOnInfoListener { mediaPlayer, what, extras ->

            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                binding.barraProgreso2.visibility = View.INVISIBLE
            true
        }
    }

    /**
     * Metodo para pausar el video 1
     */
    fun pausarVideo1() {
        binding.videoView.pause() // pauso el video 1
        posicionVideo1 = binding.videoView.currentPosition // y guardamos su posicion actual para que al volver a darle a play vaya hacia donde lo dejamos pausado
    }

    /**
     * Metodo para pausar el video 2
     */
    fun pausarVideo2() {
        binding.videoView2.pause() // pauso el video 2
        posicionVideo2 = binding.videoView2.currentPosition // y guardamos su posicion actual para que al volver a darle a play vaya hacia donde lo dejamos pausado
    }

}