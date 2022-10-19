package com.example.fragmentocolores

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.IntegerRes

class MainActivity : AppCompatActivity(), Comunicador {

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClickRojoSuma() {
        var suma = findViewById<TextView>(R.id.textView)
        contador++
        suma.text = contador.toString()
    }

    override fun onClickVerdeResta() {
        Toast.makeText(this, "Has pulsado", Toast.LENGTH_SHORT)
        val valor = this.findViewById<TextView>(R.id.textView)
        val resto = Integer.parseInt(valor.text.toString())-1
        valor.setText(resto.toString())
    }
}