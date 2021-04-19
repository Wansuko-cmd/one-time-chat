package com.example.routes

import com.example.routes.chat.chatRoutes
import io.ktor.routing.*
import io.ktor.application.*

fun Application.mainRoutes() {
    routing {
        chatRoutes()
    }
}
