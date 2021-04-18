package com.example

import com.example.routing.configureRouting
import io.ktor.application.*


fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)


fun Application.main() {
    configureRouting()
}
