package com.example.routes.chat

import io.ktor.http.cio.websocket.*

data class Connection(
    val session: DefaultWebSocketSession,
    val name: String,
    val hash: String
    )
