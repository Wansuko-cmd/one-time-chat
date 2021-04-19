package com.example.routes

import com.example.db.tables.Users
import com.example.factories.DatabaseFactory
import com.example.routes.chat.chatRoutes
import com.typesafe.config.ConfigFactory
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.config.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.mainRoutes() {

    routing {
        chatRoutes()
    }

    val database = DatabaseFactory

//    routing {
//        get("/") {
//            database.init()
//            transaction {
//                Users.insert {
//                    it[name]="Test"
//                    it[imagePath] = "TEST"
//                }
//            }
//            call.respondText(database.toString())
//        }
//
//        get("/test"){
//            val appConfig = HoconApplicationConfig(ConfigFactory.load())
//            call.respondText(appConfig.property("db.driverClass").getString())
//        }
//    }
}
