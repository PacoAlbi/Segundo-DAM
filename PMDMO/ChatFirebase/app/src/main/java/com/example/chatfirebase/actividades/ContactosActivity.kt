package com.example.chatfirebase.actividades

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
    private val listaUsuariosRegistrados = mutableListOf<String>()

    private lateinit var btnAgregar: ImageButton
    private lateinit var contactos: RecyclerView
    private lateinit var emailEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contactos)

        obtenerUsuariosRegistrados()
        intent.getStringExtra("usuario")?.let { usuario = it }

        btnAgregar = findViewById(R.id.btnAgregar)
        contactos = findViewById(R.id.contactos)
        emailEditText = findViewById(R.id.emailEt)

        if (usuario.isNotEmpty()) {
            cargarContactos()
        }
    }

    /**
     * Metodo que inicializa la pagina de contactos obteniendo las colecciones de la base de datos de Firestore para añadir los chats en los RecyclerViews
     */
    private fun cargarContactos() {

        btnAgregar.setOnClickListener {

            if(comprobarSiUsuarioExiste(emailEditText.text.toString())){
                crearNuevoChat()
            }else{
                Toast.makeText(
                    applicationContext,
                    "ESTE USUARIO NO ESTA REGISTRADO",
                    Toast.LENGTH_LONG
                ).show()
            }

        }

        contactos.layoutManager = LinearLayoutManager(this)
        contactos.adapter = AdaptadorChat { chat -> crearAlerta(chat) }
        val usuarioObtenido = database.collection("usuarios").document(usuario)

        usuarioObtenido.collection("chats")
            .get()
            .addOnSuccessListener { chats ->
                val listChats = chats.toObjects(Chat::class.java)

                (contactos.adapter as AdaptadorChat).setData(listChats)
            }

        usuarioObtenido.collection("chats")
            .addSnapshotListener { chats, error ->
                if (error == null) {
                    chats?.let {
                        val listChats = it.toObjects(Chat::class.java)

                        (contactos.adapter as AdaptadorChat).setData(listChats)
                    }
                }
            }
    }

    fun crearAlerta(chat: Chat) {

        val builder = AlertDialog.Builder(this)

        // Título de la alerta
        builder.setTitle("¿Que quieres hacer?")

        // Opciones de la alerta
        val opciones = arrayOf("Entrar al chat", "Borrar chat")
        builder.setItems(opciones) { dialog, which ->
            // Acción a realizar al seleccionar una opción
            when (which) {
                0 -> {
                    seleccionarChat(chat)
                }
                1 -> {
                    borrarChat(chat)
                }
            }
        }

        // Crear y mostrar la alerta
        val alerta = builder.create()
        alerta.show()
    }

    fun borrarChat(chat: Chat){

        val buildAlerta = AlertDialog.Builder(this)
        val documentoChat = database.collection("chats").document(chat.id)
        val chatUsuario = database.collection("usuarios").document("chats").collection(chat.id).document()

        chatUsuario.delete()
            .addOnSuccessListener {

                buildAlerta.setTitle("EXITO")
                buildAlerta.setMessage("Chat borrado correctamente.")

                val alerta = buildAlerta.create()
                alerta.show()

            }
            .addOnFailureListener { e ->

                buildAlerta.setTitle("ERROR")
                buildAlerta.setMessage("No se ha podido borrar el chat")

                val alerta = buildAlerta.create()
                alerta.show()
            }

        documentoChat.delete()
            .addOnSuccessListener {

                buildAlerta.setTitle("EXITO")
                buildAlerta.setMessage("Chat borrado correctamente.")

                val alerta = buildAlerta.create()
                alerta.show()

            }
            .addOnFailureListener { e ->

                buildAlerta.setTitle("ERROR")
                buildAlerta.setMessage("No se ha podido borrar el chat")

                val alerta = buildAlerta.create()
                alerta.show()
            }

    }

    /**
     * Metodo para navegar al chat que se introduce como parametro
     */
    private fun seleccionarChat(chat: Chat) {

        val intent = Intent(this, ConversacionActivity::class.java)
        intent.putExtra("idChat", chat.id)
        intent.putExtra("usuario", usuario)
        startActivity(intent)

    }

    /**
     * Metodo para agregar un chat nuevo en la base de datos de Firestore y entrar en el
     */
    private fun crearNuevoChat() {

        val chatId = UUID.randomUUID().toString() // crea variable id random
        val elOtro = emailEditText.text.toString()

        val nombreDelOtro = elOtro.split("@")[0];
        val chatAIntroducir = Chat(
            id = chatId,
            nombre = nombreDelOtro
        )

        // creamos en la base de datos las colecciones con los campos que hemos creado con el objeto de tipo Chat
        database.collection("chats").document(chatId).set(chatAIntroducir)
        database.collection("usuarios").document(usuario).collection("chats").document(chatId)
            .set(chatAIntroducir)
        database.collection("usuarios").document(elOtro).collection("chats").document(chatId)
            .set(chatAIntroducir)

        // y despues navegamos al chat con el id del chat y el email como parametro
        val intent = Intent(this, ConversacionActivity::class.java)
        intent.putExtra("idChat", chatId)
        intent.putExtra("usuario", usuario)
        startActivity(intent)
    }

    /**
     * Metodo que obtiene todos los usuarios (emails) que se hayan registrado en la base de datos
     */
    private fun obtenerUsuariosRegistrados() {

        val coleccion = database.collection("usuariosRegistrados")

        coleccion.get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    // Acceder a los campos de cada documento
                    val campo = document.getString("email")
                    listaUsuariosRegistrados.add(campo!!)
                    // Hacer algo con los campos obtenidos
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error obteniendo documentos: ", exception)
            }

    }

    private fun comprobarSiUsuarioExiste(email: String): Boolean{

        var existe: Boolean = false

        for (i in listaUsuariosRegistrados.indices) {

            if(listaUsuariosRegistrados[i].equals(email)){
                existe = true
            }

        }

        return existe;
    }

}