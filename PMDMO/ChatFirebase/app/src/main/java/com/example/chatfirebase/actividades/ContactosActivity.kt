package com.example.chatfirebase.actividades

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatfirebase.R
import com.example.chatfirebase.adaptadores.AdaptadorChat
import com.example.chatfirebase.clases.Chat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class ContactosActivity : AppCompatActivity() {

    private var usuario = ""

    private var database = Firebase.firestore

    private lateinit var btnAgregar: Button
    private lateinit var contactos: RecyclerView
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactos)

        intent.getStringExtra("usuario")?.let { usuario = it }

        btnAgregar = findViewById(R.id.btnAgregar)
        contactos = findViewById(R.id.contactos)
        emailEditText = findViewById(R.id.emailEt)

        if (usuario.isNotEmpty()){
            cargarContactos()
        }
    }

    /**
     * Metodo que inicializa la pagina de contactos obteniendo las colecciones de la base de datos de Firestore para añadir los chats en los RecyclerViews
     */
    private fun cargarContactos(){

        btnAgregar.setOnClickListener { crearNuevoChat() }

        contactos.layoutManager = LinearLayoutManager(this)
        contactos.adapter = AdaptadorChat { chat -> seleccionarChat(chat) }
        val usuarioObtenido = database.collection("usuarios").document(usuario)

        usuarioObtenido.collection("chats")
            .get()
            .addOnSuccessListener { chats ->
                val listChats = chats.toObjects(Chat::class.java)

                (contactos.adapter as AdaptadorChat).setData(listChats)
            }

        usuarioObtenido.collection("chats")
            .addSnapshotListener { chats, error ->
                if(error == null){
                    chats?.let {
                        val listChats = it.toObjects(Chat::class.java)

                        (contactos.adapter as AdaptadorChat).setData(listChats)
                    }
                }
            }
    }

    /**
     * Metodo para navegar al chat que se introduce como parametro
     */
    private fun seleccionarChat(chat: Chat){

        val intent = Intent(this, ConversacionActivity::class.java)
        intent.putExtra("idChat", chat.id)
        intent.putExtra("usuario", usuario)
        startActivity(intent)

    }

    /**
     * Metodo para agregar un chat nuevo en la base de datos de Firestore y entrar en el
     */
    private fun crearNuevoChat(){

        val chatId = UUID.randomUUID().toString() // crea variable id random
        val elOtro = emailEditText.text.toString()

        val chatAIntroducir = Chat(
            id = chatId,
            nombre = "Chat de " + usuario + " con " + elOtro
        )

        // creamos en la base de datos las colecciones con los campos que hemos creado con el objeto de tipo Chat
        database.collection("chats").document(chatId).set(chatAIntroducir)
        database.collection("usuarios").document(usuario).collection("chats").document(chatId).set(chatAIntroducir)
        database.collection("usuarios").document(elOtro).collection("chats").document(chatId).set(chatAIntroducir)

        // y despues navegamos al chat con el id del chat y el email como parametro
        val intent = Intent(this, ConversacionActivity::class.java)
        intent.putExtra("idChat", chatId)
        intent.putExtra("usuario", usuario)
        startActivity(intent)
    }

}