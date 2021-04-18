package com.example.routing

import com.example.db.tables.Users
import com.example.factories.DatabaseFactory
import com.typesafe.config.ConfigFactory
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.config.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting() {

    val database = DatabaseFactory

    routing {
        get("/") {
            database.init()
            transaction {
                Users.insert {
                    it[name]="Test"
                }
            }
            call.respondText(database.toString())
        }

        get("/test"){
            val appConfig = HoconApplicationConfig(ConfigFactory.load())
            call.respondText(appConfig.property("db.driverClass").getString())
        }
    }
}
