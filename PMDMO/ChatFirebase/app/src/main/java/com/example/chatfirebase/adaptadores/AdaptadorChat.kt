package com.example.chatfirebase.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatfirebase.R
import com.example.chatfirebase.clases.Chat

class AdaptadorChat(val chatClick: (Chat) -> Unit): RecyclerView.Adapter<AdaptadorChat.ChatViewHolder>() {

    var listaChats: List<Chat> = emptyList()

    fun setData(list: List<Chat>){
        listaChats = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.chat,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.nombreChat.text = listaChats[position].nombre

        holder.itemView.setOnClickListener {
            chatClick(listaChats[position])
        }
    }

    override fun getItemCount(): Int {
        return listaChats.size
    }

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nombreChat: TextView

        init {
            // Define click listener for the ViewHolder's View.
            nombreChat = view.findViewById(R.id.nombreChat)
        }
    }
}