package com.example.routes.chat

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.chatRoutes(){
    get("/chat") {
        call.respondText("chats")
    }
}
