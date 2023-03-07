package com.example.piedrapapeltijera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.piedrapapeltijera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentListener {

//    private lateinit var binding: ActivityMainBinding
    private var puntuacionUsuario = 0
    private var puntuacionMaquina = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)


    }
    fun tiradaMaquina (imgMaquina: ImageView): String {
        val tiradaMaquina = arrayOf("piedra", "papel", "tijeras", "lagarto", "spok").random()
        when (tiradaMaquina) {
            "piedra" -> imgMaquina.setImageResource(R.drawable.piedra)
            "papel" -> imgMaquina.setImageResource(R.drawable.papel)
            "tijeras" -> imgMaquina.setImageResource(R.drawable.tijeras)
            "lagarto" -> imgMaquina.setImageResource(R.drawable.lagarto)
            "spok" -> imgMaquina.setImageResource(R.drawable.spok)
        }
        return tiradaMaquina
    }
    override fun ClickFragmentBtnPiedra() {
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.txtMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.txtUsuario)
        imgUsuario.setImageResource(R.drawable.piedra)
        tiradaMaquina(imgMaquina)
        jugar("piedra",tiradaMaquina(imgMaquina),puntosUsuario,puntosMaquina)

    }
    override fun ClickFragmentBtnPapel() {
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.txtMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.txtUsuario)
        imgUsuario.setImageResource(R.drawable.papel)
        jugar("papel",tiradaMaquina(imgMaquina),puntosUsuario,puntosMaquina)
    }
    override fun ClickFragmentBtnTijeras() {
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.txtMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.txtUsuario)
        imgUsuario.setImageResource(R.drawable.tijeras)
        jugar("tijeras",tiradaMaquina(imgMaquina),puntosUsuario,puntosMaquina)
    }
    override fun ClickFragmentBtnLagarto() {
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.txtMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.txtUsuario)
        imgUsuario.setImageResource(R.drawable.lagarto)
        jugar("lagarto",tiradaMaquina(imgMaquina),puntosUsuario,puntosMaquina)
    }
    override fun ClickFragmentBtnSpok() {
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.txtMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.txtUsuario)
        imgUsuario.setImageResource(R.drawable.spok)
        jugar("spok",tiradaMaquina(imgMaquina),puntosUsuario,puntosMaquina)
    }
    fun jugar(tiradaUsusario: String, tiradaMaquina: String, puntosUsuario: TextView, puntosMaquina: TextView) {
        when (tiradaMaquina) {
            "piedra" ->
                when (tiradaUsusario) {
                "papel" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "tijeras" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
                "lagarto" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
                "spok" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
            }
            "papel" ->
                when (tiradaUsusario) {
                "piedra" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
                "tijeras" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "lagarto" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "spok" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
            }
            "tijeras" ->
                when (tiradaUsusario) {
                "piedra" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "papel" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
                "lagarto" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
                "spok" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
            }
            "lagarto" ->
                when (tiradaUsusario) {
                "piedra" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "tijeras" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "spok" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
                "papel" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
            }
            "spok" ->
                when (tiradaUsusario) {
                "papel" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "lagarto" -> {
                    puntuacionUsuario++
                    puntosUsuario.text = puntuacionUsuario.toString()
                }
                "piedra" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
                "tijeras" -> {
                    puntuacionMaquina++
                    puntosMaquina.text = puntuacionMaquina.toString()
                }
            }
        }
        comprobarGanador()
    }
    fun comprobarGanador(){
        val alerta: AlertDialog.Builder
        if(puntuacionUsuario == 5){
            alerta = AlertDialog.Builder(this)
            alerta.setTitle("Gana el usuario")
                .setMessage("¿Que desea hacer?")
                .setPositiveButton("¿Otra partidita?") { dialog, which ->
                    reiniciar()
                }
                .setNegativeButton("Salir") { dialog, which ->
                    finish()
                }
            alerta.setCancelable(false)
            alerta.show() // esta linea es para que se muestre la alerta del usuario
        }else if(puntuacionMaquina == 5){
            alerta = AlertDialog.Builder(this)
            alerta.setTitle("Gana la maquina")
                .setMessage("¿Que desea hacer?")
                .setPositiveButton("¿Otra partidita?") { dialog, which ->
                    reiniciar()
                }
                .setNegativeButton("Salir") { dialog, which ->
                    finish()
                }
            alerta.setCancelable(false)
            alerta.show() // esta linea es para que se muestre la alerta de la maquina
        }
    }
    fun reiniciar(){
        puntuacionUsuario = 0
        puntuacionMaquina = 0
        val imgUsuario = findViewById<ImageView>(R.id.imgUsuario)
        val imgMaquina = findViewById<ImageView>(R.id.imgMaquina)
        val puntosMaquina = findViewById<TextView>(R.id.txtMaquina)
        val puntosUsuario = findViewById<TextView>(R.id.txtUsuario)
        imgUsuario.setImageResource(0)
        imgMaquina.setImageResource(0)
        puntosMaquina.text = puntuacionMaquina.toString()
        puntosUsuario.text = puntuacionUsuario.toString()
    }
}