package com.example.piedrapapeltijera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ImageButton
import android.widget.TextView
import com.example.piedrapapeltijera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var eleccionUsuario: String
    private lateinit var eleccionMaquina: String
    private var puntuacuinUsuario = 0
    private var puntuacionMaquina = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //txtvMaquina = findViewById(R.id.txtvMaquina);
        //txtvUsuario = findViewById(R.id.txtvUsuario);

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val btnPiedra = binding.root.
        val btnPapel = findViewById<ImageButton>(R.id.imgPapel)
        val btnTijeras = findViewById<ImageButton>(R.id.imgTijeras)

        btnPiedra.setOnClickListener { jugar("piedra") }
        //btnPiedra.setOnClickListener { listener?.onClickFragmentButtonPiedra() }
        btnPapel.setOnClickListener { jugar("papel") }
        //btnPapel.setOnClickListener { listener?.onClickFragmentButtonPapel() }
        btnTijeras.setOnClickListener{ jugar("tijeras") }
        //btnTijeras.setOnClickListener{listener?.onClickFragmentButtonTijeras()}


    }

    private fun jugar(eleccionUsuario: String) {
        val eleccionMaquina = arrayOf("piedra", "papel", "tijeras").random()

        when (eleccionMaquina) {
            "piedra" ->
                when (eleccionUsuario) {
                "piedra" -> txtvUsuario.text = "Empate"
                "papel" -> txtvUsuario.text = "Has ganado"
                "tijeras" -> txtvUsuario.text = "Has perdido"
            }
            "papel" ->
                when (eleccionUsuario) {
                "piedra" -> txtvUsuario.text = "Has perdido"
                "papel" -> txtvUsuario.text = "Empate"
                "tijeras" -> txtvUsuario.text = "Has ganado"
            }
            "tijeras" ->
                when (eleccionUsuario) {
                "piedra" -> txtvUsuario.text = "Has ganado"
                "papel" -> txtvUsuario.text = "Has perdido"
                "tijeras" -> txtvUsuario.text = "Empate"
            }
        }
    }

}