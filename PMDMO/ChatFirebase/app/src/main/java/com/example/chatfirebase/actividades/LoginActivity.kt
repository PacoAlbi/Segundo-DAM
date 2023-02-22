package com.example.chatfirebase.actividades

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.chatfirebase.R
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    private lateinit var loginEmail: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var loginGoRegisterButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        auth = Firebase.auth;

        loginEmail = findViewById(R.id.loginEmail)
        loginPassword = findViewById(R.id.loginPassword)
        loginButton = findViewById(R.id.loginButton)
        loginGoRegisterButton = findViewById(R.id.loginGoRegisterButton)

        // cuando pulse el boton de logeo, envia el email y contraseña al metodo para logearse si ninguno esta vacio
        loginButton.setOnClickListener {

            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()

            if(comprobarCampos(email,password)){
                logearse(email,password)
            }
        }

        // cuando pulse el boton para registrarnos, nos enviara a la pagina de registro
        loginGoRegisterButton.setOnClickListener {

            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }

    /**
     * Metodo para iniciar sesion en la aplicacion recibiendo como parametros el email y la contraseña del usuario que quiere iniciar sesion.
     */
    private fun logearse(email: String, password: String) {

        val usuarioActual = auth.currentUser

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->

                // si consigue logearse navegamos hacia la pagina de contactos mandandole el email del usuario como "parametro"
                if (task.isSuccessful) {
                    val intent = Intent(this, ContactosActivity::class.java)
                    intent.putExtra("usuario", usuarioActual?.email)

                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Fallo al iniciar sesion",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }
    }

    /**
     * Funcion que comprueba si algun campo esta vacio, devuelve true si cualquier campo esta sin rellenar
     */
    private fun comprobarCampos(email: String, password: String): Boolean {

        return email.isNotEmpty() && password.isNotEmpty()
    }
}