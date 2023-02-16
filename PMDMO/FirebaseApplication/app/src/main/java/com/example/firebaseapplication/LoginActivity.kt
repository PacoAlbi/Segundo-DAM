package com.example.firebaseapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var loginEmail: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var loginGoRegisterButton: Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginEmail = findViewById(R.id.loginEmail)
        loginPassword = findViewById(R.id.loginPassword)
        loginButton = findViewById(R.id.loginButton)
        loginGoRegisterButton = findViewById(R.id.loginGoRegisterButton)

        auth = Firebase.auth

        loginButton.setOnClickListener {
            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()
            if (checkEmpty(email, password)){
                login(email, password)
            }
        }
        loginGoRegisterButton.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
    //Comprobamos que cuando inicie no este ya conectado antes con su cuenta google
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            //reload()
        }
    }

    private fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){task ->
                if (task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }else{
                    Toast.makeText(applicationContext, "Usuario no encontrado", Toast.LENGTH_LONG).show()
                }
            }
    }

    private fun checkEmpty(email: String, password: String): Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }
}