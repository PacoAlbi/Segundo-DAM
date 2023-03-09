package com.example.dicesimon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.dicesimon.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SimonListener {

    private val secuenciaRandom = mutableListOf<String>()
    private val secuenciaJugador = mutableListOf<String>()
    private val TOTAL_NIVELES = 10
    private val COLORES = listOf("Amarillo","Azul","Rojo","Verde")
    private var velocidad = 100L
    private var nivel = 0
    private var fallas = false
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        binding.txtNivel.isVisible = false
        onClickAmarillo()
        onClickAzul()
        onClickRojo()
        onClickVerde()
    }

    fun iniciarPartida() {
        binding.txtNivel.isVisible = true
        generarSecuencia()
        repetirSecuencia()
    }

    fun generarSecuencia() {
        for (i in 0..nivel) {
            secuenciaRandom.add(COLORES.random())
        }
        nivel++
        binding.txtNivel.text = "Nivel $nivel"
    }

    fun repetirSecuencia() {
        apagarBotones()
        for (i in secuenciaRandom) {
            when (i) {
                "Amarillo" -> {
                    binding.btnAmarillo.postDelayed({
                        binding.btnAmarillo.setBackgroundColor(getColor(R.color.darkyellow))
                    }, velocidad)
                    binding.btnAmarillo.setBackgroundColor(getColor(R.color.yellow))
                }
                "Azul" -> {
                    binding.btnAzul.postDelayed({
                        binding.btnAzul.setBackgroundColor(getColor(R.color.darkblue))
                    }, velocidad)
                    binding.btnAzul.setBackgroundColor(getColor(R.color.blue))
                }
                "Rojo" -> {
                    binding.btnRojo.postDelayed({
                        binding.btnRojo.setBackgroundColor(getColor(R.color.darkred))
                    }, velocidad)
                    binding.btnRojo.setBackgroundColor(getColor(R.color.red))
                }
                "Verde" -> {
                    binding.btnVerde.postDelayed({
                        binding.btnVerde.setBackgroundColor(getColor(R.color.darkgreen))
                    }, velocidad)
                    binding.btnVerde.setBackgroundColor(getColor(R.color.green))
                }
            }
        }
        encenderBotones()
    }

    fun comprobarSecuencia () {
        for (i in 0..secuenciaJugador.size) {
                if (!secuenciaJugador[i].equals(secuenciaRandom[i])){
                    fallas = true
                }
            }
    }

    fun onClickAmarillo() {
        binding.btnAmarillo.setOnClickListener {
            secuenciaJugador.add("Amarillo")
            binding.btnAmarillo.setBackgroundColor(getColor(R.color.darkyellow))
            binding.btnAmarillo.postDelayed({
                binding.btnAmarillo.setBackgroundColor(getColor(R.color.yellow))
            }, velocidad)
            //comprobarGanador()
        }
    }

    fun onClickAzul() {
        binding.btnAzul.setOnClickListener {
            secuenciaJugador.add("Azul")
            binding.btnAzul.setBackgroundColor(getColor(R.color.darkblue))
            binding.btnAzul.postDelayed({
                binding.btnAzul.setBackgroundColor(getColor(R.color.blue))
            }, velocidad)
            //comprobarGanador()
        }
    }

    fun onClickRojo() {
        binding.btnRojo.setOnClickListener {
            secuenciaJugador.add("Rojo")
            binding.btnRojo.setBackgroundColor(getColor(R.color.darkred))
            binding.btnRojo.postDelayed({
                binding.btnRojo.setBackgroundColor(getColor(R.color.red))
            }, velocidad)
            //comprobarGanador()
        }
    }

    fun onClickVerde() {
        binding.btnVerde.setOnClickListener {
            secuenciaJugador.add("Verde")
            binding.btnVerde.setBackgroundColor(getColor(R.color.darkgreen))
            binding.btnVerde.postDelayed({
                binding.btnVerde.setBackgroundColor(getColor(R.color.green))
            }, velocidad)
            //comprobarGanador()
        }
    }

    override fun onClickFacil() {
        val btnFacil = findViewById<Button>(R.id.btnFacil)
        btnFacil.setOnClickListener {
            velocidad = 1000L
            iniciarPartida()
        }
    }

    override fun onClickMedio() {
        val btnMedio = findViewById<Button>(R.id.btnMedio)
        btnMedio.setOnClickListener {
            velocidad = 500L
            iniciarPartida()
        }
    }

    override fun onClickDificil() {
        val btnDificil = findViewById<Button>(R.id.btnDificil)
        btnDificil.setOnClickListener {
            velocidad = 250L
            iniciarPartida()
        }
    }

    fun comprobarGanador(){
        comprobarSecuencia()
        val alerta: AlertDialog.Builder
        if(nivel == TOTAL_NIVELES && !fallas){
            alerta = AlertDialog.Builder(this)
            alerta.setTitle("¡Ganaste! Enhorabuena :)")
                .setMessage("¿Otra partidita?")
                .setPositiveButton("¡SI!") { dialog, which ->
                    reiniciar()
                }
                .setNegativeButton("Salir") { dialog, which ->
                    finish()
                }
            alerta.setCancelable(false)
            alerta.show()
        }else {
            alerta = AlertDialog.Builder(this)
            alerta.setTitle("Has perdido, ohhhhh :(")
                .setMessage("¿Otra partidita?")
                .setPositiveButton("¡SI!") { dialog, which ->
                    reiniciar()
                }
                .setNegativeButton("Salir") { dialog, which ->
                    finish()
                }
            alerta.setCancelable(false)
            alerta.show()
        }
    }

    fun encenderBotones(){
        binding.btnAmarillo.isClickable = true
        binding.btnAzul.isClickable = true
        binding.btnVerde.isClickable = true
        binding.btnRojo.isClickable = true
    }

    fun apagarBotones(){
        binding.btnAmarillo.isClickable = false
        binding.btnAzul.isClickable = false
        binding.btnVerde.isClickable = false
        binding.btnRojo.isClickable = false
    }

    fun reiniciar() {
        secuenciaJugador.clear()
        secuenciaRandom.clear()
        binding.txtNivel.text = "1"
        generarSecuencia()
    }
}