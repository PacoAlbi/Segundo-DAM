package com.example.chatfirebase.clases

import java.util.*

data class Mensaje (
    var texto: String = "",
    var de: String = "",
    var fecha: Date = Date()
)