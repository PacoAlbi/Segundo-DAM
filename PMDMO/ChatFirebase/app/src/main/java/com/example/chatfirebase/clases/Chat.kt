package com.example.chatfirebase.clases

data class Chat(
    var id: String = "",
    var nombre: String = "",
    var usuarios: List<String> = emptyList()
)