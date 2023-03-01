package com.example.examenfinalpruebaandroid

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import com.example.examenfinalpruebaandroid.databinding.ActivityReproductorBinding

class ReproductorActivity : AppCompatActivity() {


    var url: String? = null
    var binding: ActivityReproductorBinding? = null
    var posicionVideo = 0
    private lateinit var mediaController: MediaController
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReproductorBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        intent.getStringExtra("url")?.let { url = it }
        binding!!.btnVolver.setOnClickListener { clickVolver() }
        reproducirVideo()
    }


    fun clickVolver() {
        mediaPlayer = MediaPlayer.create(this, R.raw.snd_boton)
        mediaPlayer.start()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    fun reproducirVideo() {
        mediaController = MediaController(this)

        binding!!.videoView.setOnPreparedListener {
            mediaController.setAnchorView(binding!!.frameVideo)
            binding!!.videoView.setMediaController(mediaController) // para settear el mediacontroller del video 1
            binding!!.videoView.seekTo(posicionVideo) // la posicion del video va hacia el entero posicionVideo1, que esta inicializado en 0 para que empiece desde el principio
            binding!!.videoView.start() // inicia el video 1
        }

        binding!!.videoView.setOnInfoListener { _, what, extras ->

            if (what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                binding!!.barraProgreso.visibility = View.INVISIBLE
            true
        }
    }

    fun pausarVideo() {
        binding!!.videoView.pause() // pauso el video 1
        posicionVideo =
            binding!!.videoView.currentPosition // y guardamos su posicion actual para que al volver a darle a play vaya hacia donde lo dejamos pausado
    }

    override fun onStart() {
        super.onStart()

        binding!!.videoView.setVideoURI(Uri.parse(url))
        binding!!.barraProgreso.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()

        pausarVideo()
    }

    override fun onStop() {

        binding!!.videoView.stopPlayback()
        super.onStop()
    }
}