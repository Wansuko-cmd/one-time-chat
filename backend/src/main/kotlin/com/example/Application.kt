package com.example

import com.example.factories.DatabaseFactory
import com.example.routes.mainRoutes
import io.ktor.application.*
import io.ktor.http.cio.websocket.*
import io.ktor.routing.*
import io.ktor.websocket.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.main() {

    install(WebSockets)


    val databaseFactory = DatabaseFactory
    databaseFactory.init()

    mainRoutes()
}
