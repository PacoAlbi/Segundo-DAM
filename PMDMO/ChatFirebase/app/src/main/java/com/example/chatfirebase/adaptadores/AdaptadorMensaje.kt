package com.example.chatfirebase.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.chatfirebase.R
import com.example.chatfirebase.clases.Mensaje
import java.text.SimpleDateFormat

class AdaptadorMensaje(private val user: String): RecyclerView.Adapter<AdaptadorMensaje.MessageViewHolder>() {

    private var listaMensajes: List<Mensaje> = emptyList()

    fun setData(list: List<Mensaje>){
        listaMensajes = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.mensaje,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {

        val mensaje = listaMensajes[position]
        val formatoHora = SimpleDateFormat("HH:mm")

        if(user == mensaje.de){
            holder.layoutMiMensaje.visibility = View.VISIBLE
            holder.layoutSuMensaje.visibility = View.GONE

            holder.miMensaje.text = mensaje.texto
            holder.fechaMiMensaje.text = formatoHora.format(mensaje.fecha)

        } else {
            holder.layoutMiMensaje.visibility = View.GONE
            holder.layoutSuMensaje.visibility = View.VISIBLE

            holder.suMensaje.text = mensaje.texto
            holder.fechaSuMensaje.text = formatoHora.format(mensaje.fecha)
        }

    }

    override fun getItemCount(): Int {
        return listaMensajes.size
    }

    class MessageViewHolder(view: View): RecyclerView.ViewHolder(view){

         val layoutMiMensaje: ConstraintLayout
         val layoutSuMensaje: ConstraintLayout

        val miMensaje: TextView
        val suMensaje: TextView

        val fechaMiMensaje: TextView
        val fechaSuMensaje: TextView

        init {
            // Define click listener for the ViewHolder's View.
            miMensaje = view.findViewById(R.id.miMensajeTxt)
            suMensaje = view.findViewById(R.id.suMensajeTxt)
            fechaMiMensaje = view.findViewById(R.id.fechaMiMensaje)
            fechaSuMensaje = view.findViewById(R.id.fechaSuMensaje)
            layoutMiMensaje = view.findViewById(R.id.miMensajeLayout)
            layoutSuMensaje = view.findViewById(R.id.suMensajeLayout)
        }
    }
}