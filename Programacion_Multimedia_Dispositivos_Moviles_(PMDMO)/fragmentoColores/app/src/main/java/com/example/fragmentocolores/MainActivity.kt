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
import androidx.appcompat.app.AlertDialog

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
        Toast.makeText(this, "Has pulsado", Toast.LENGTH_SHORT) //El toast no funciona por el contexto
        val valor = this.findViewById<TextView>(R.id.textView)
        val resto = Integer.parseInt(valor.text.toString())-1
        if (contador == 10){
            AlertDialog.Builder(this)
                .setTitle("¿Para Pesao!")
                .setMessage("Ya van 10")
                .setPositiveButton("Si, quiero rayarte"){dialog, which->
                    valor.setText(contador.toString())
                }
                //Ponemos null y se cierra solo
                .setNegativeButton("Paso", null)
                .setIcon(android.R.drawable.btn_dialog)
                .show()
        }else{
            valor.setText(resto.toString())
        }
    }
}