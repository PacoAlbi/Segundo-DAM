package com.example.chatfirebase.actividades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatfirebase.R
import com.example.chatfirebase.adaptadores.AdaptadorMensaje
import com.example.chatfirebase.clases.Mensaje
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class ConversacionActivity : AppCompatActivity() {
    private var idChat = ""
    private var usuario = ""

    private var database = FirebaseFirestore.getInstance()

    private lateinit var btnEnviar: ImageButton
    private lateinit var mensajeEditText: EditText
    private lateinit var mensajes: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conversacion)

        btnEnviar = findViewById(R.id.btnEnviar)
        mensajeEditText = findViewById(R.id.mensajeEt)
        mensajes = findViewById(R.id.mensajes)

        intent.getStringExtra("idChat")?.let { idChat = it }
        intent.getStringExtra("usuario")?.let { usuario = it }

        if(idChat.isNotEmpty() && usuario.isNotEmpty()) {
            cargarMensajes()
        }
    }

    /**
     * Metodo que inicializa la pagina del chat obteniendo las colecciones de la base de datos de Firestore para añadir los mensajes en los RecyclerViews de la pagina del chat
     */
    private fun cargarMensajes(){

        mensajes.layoutManager = LinearLayoutManager(this)
        mensajes.adapter = AdaptadorMensaje(usuario)

        btnEnviar.setOnClickListener { enviarMensaje() }

        val chatRef = database.collection("chats").document(idChat)

        chatRef.collection("mensajes").orderBy("fecha", Query.Direction.ASCENDING)
            .get()
            .addOnSuccessListener { mensaje ->
                val listaDeMensajes = mensaje.toObjects(Mensaje::class.java)
                (mensajes.adapter as AdaptadorMensaje).setData(listaDeMensajes)
            }

        chatRef.collection("mensajes").orderBy("fecha", Query.Direction.ASCENDING)
            .addSnapshotListener { mensaje, error ->
                if(error == null){
                    mensaje?.let {
                        val listaMensajes = it.toObjects(Mensaje::class.java)
                        (mensajes.adapter as AdaptadorMensaje).setData(listaMensajes)
                    }
                }
            }
    }

    /**
     * Metodo que crea un mensaje y lo introduce en la base de datos de Firestore
     */
    private fun enviarMensaje(){

        val mensajeAIntroducir = Mensaje(
            texto = mensajeEditText.text.toString(),
            de = usuario
        )

        // introduzco el mensaje en la coleccion de chats
        // le paso el idChat al documento para que el mensaje se guarde solo en el chat en el que nos encontramos (si no se guardaria en todos los chats existentes)
        database.collection("chats").document(idChat).collection("mensajes").document().set(mensajeAIntroducir)

        // aqui pongo vacio el edit text del mensaje para que cada vez que se envie un mensaje se borre el que se ha escrito anteriormente
        mensajeEditText.setText("")


    }
}