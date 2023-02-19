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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerEmail: EditText
    private lateinit var registerPassword: EditText
    private lateinit var registerRepeatPassword: EditText
    private lateinit var registerButton: Button
    private lateinit var registerGoLoginButton: Button

    private var database = Firebase.firestore
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth

        registerEmail = findViewById(R.id.registerEmail)
        registerPassword = findViewById(R.id.registerPassword)
        registerRepeatPassword = findViewById(R.id.registerRepeatPassword)
        registerButton = findViewById(R.id.registerButton)
        registerGoLoginButton = findViewById(R.id.registerGoLoginButton)

        registerButton.setOnClickListener {

            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()
            val repeatPassword = registerRepeatPassword.text.toString()

            if(password.equals(repeatPassword) && comprobarCampos(email,password,repeatPassword)){
                registrarse(email,password)
            }
        }

        registerGoLoginButton.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    /**
     * Metodo para registrarnos en la aplicacion que recibe el email y la contraseña como parametro
     */
    private fun registrarse(email: String, password: String) {

        val usuarioActual = auth.currentUser

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){ task ->

                // si consigue registrarse, navega hacia la pagina de contactos mandandole el email como "parametro"
                if(task.isSuccessful){


                    val intent = Intent(this, ContactosActivity::class.java)
                    intent.putExtra("usuario",usuarioActual?.email)
                    startActivity(intent)
                    finish()

                }else{
                    Toast.makeText(applicationContext,"Fallo al registrarse", Toast.LENGTH_LONG).show()
                }
            }
    }

    /**
     * Funcion que comprueba si algun campo esta vacio, devuelve true si cualquier campo esta sin rellenar
     */
    private fun comprobarCampos(email: String, password: String, repeatPassword: String): Boolean {

        return email.isNotEmpty() && password.isNotEmpty() && repeatPassword.isNotEmpty()
    }
}