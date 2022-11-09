package com.example.pptlagartospok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //Retraso la splash para que se vea
        Thread.sleep(2000)
        //En el manifest pongo el tema de la activiti en el mio, y cuando sale lo cambio al por defecto despues.
        setTheme(R.style.Theme_PPTLagartoSpok)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}