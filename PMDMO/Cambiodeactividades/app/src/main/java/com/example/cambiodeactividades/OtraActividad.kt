package com.example.cambiodeactividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class OtraActividad : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otra_actividad)
        btnVolver.setOnClickListener {
            onClick(it)
        }
    }
    fun onClick(view: android.view.View) {
        val intent = Intent()
        val datos = "Estos son datos generados en ${OtraActividad::class.simpleName}"
        intent.putExtra("datos", datos)
        setResult(RESULT_OK, intent)
        finish()
    }
}