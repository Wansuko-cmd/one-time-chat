package com.example.routes.chat

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*

fun Route.chatRoutes(){
    get("/chat") {

        val hash = UUID.randomUUID().toString()
        call.respondRedirect("/chat/$hash")
    }

    get("/chat/{hash}") {
        val hash = call.parameters["hash"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)

        call.respondText(hash)
    }
}
