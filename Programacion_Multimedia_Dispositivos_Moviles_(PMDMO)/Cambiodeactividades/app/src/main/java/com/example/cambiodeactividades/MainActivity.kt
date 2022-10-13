package com.example.cambiodeactividades

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        Log.d("MainActivity", "vengo")              // Se muestra en Log la vuelta
        if (result.resultCode == Activity.RESULT_OK) {      // Si ha ido bien...
            Log.d("MainActivity", "OK")             // Se muestra el mensaje OK
            val data: Intent? = result.data                 // Se recoge el resultado del Intent devuelto

            if (data != null) {                             // Si el dato no es nulo...
                Log.d("MainActivity", data.toString())  // Se muestran los datos devueltos
                // Se muestra en la etiqueta el dato devuelto
                findViewById<Button>(R.id.tvSaludo).text = data.getStringExtra("nombre")
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnCambiarSaludo).setOnClickListener {
            val intent = Intent(this, OtraActividad::class.java)
            startActivity(intent)
        }
        btnLanzarSegundaActividad.setOnClickListener {
            val intent = Intent(this, OtraActividad::class.java)   // Declaramos un Intent para cambiar a la "Otra" actividad
            findViewById<Button>(R.id.btnCambiarSaludo).setOnClickListener { // Asociamos el cambio de pantalla a un botón
                Log.d("MainActivity", "voy") // Mostramos un Log para ver que se realiza el cambio
                getResult.launch(intent)    // Se lanza el intent para cambiar de pantalla    }
            }
        }
    }
}