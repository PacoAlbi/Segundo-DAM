package com.example.cursoweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnMostrarNombre).setOnClickListener {
            checkValue()
        }
    }

    fun checkValue (){
        if (findViewById<EditText>(R.id.etNombre).text.isNotEmpty()){
            //Nueva pantalla
        } else {
            showError()
        }
    }

    fun showError () {
        Toast.makeText(this, "Debes introducir un nombre", Toast.LENGTH_SHORT).show()
    }
}