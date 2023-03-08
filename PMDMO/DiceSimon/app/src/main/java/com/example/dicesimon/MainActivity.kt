package com.example.dicesimon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragmentAmarillo, AmarilloFragment())
        fragmentTransaction.commit()


    }

    fun secuenciaJuego(): MutableList<String> {
        val colores = listOf("Amarillo","Azul","Rojo","Verde").random()
        val secuencia = mutableListOf<String>()
        when (colores) {
            "Amarillo" -> secuencia.add("Amarillo")
            "Azul" -> secuencia.add("Azul")
            "Rojo" -> secuencia.add("Rojo")
            "Verde" -> secuencia.add("Verde")
        }
        return secuencia
    }


}