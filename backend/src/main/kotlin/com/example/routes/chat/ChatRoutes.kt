package com.example.routes.chat

import com.example.db.entities.Room
import com.example.db.tables.Rooms
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import kotlin.properties.Delegates

fun Route.chatRoutes(){
    get("/chat") {
        var newHash = UUID.randomUUID().toString()
        var isExist = false

        //ユニークなチャット部屋ハッシュであることを検証
        while (true){
            transaction {
                isExist = Room.find { Rooms.hash eq newHash }.count() <= 0
            }
            if(isExist){
                break
            }
            newHash = UUID.randomUUID().toString()
        }

        transaction {
            Rooms.insert {
                it[hash] = newHash
            }
        }

        call.respondRedirect("/chat/$newHash")
    }

    get("/chat/{hash}") {
        val hash = call.parameters["hash"] ?: return@get call.respondText("Bad Request", status = HttpStatusCode.BadRequest)

        call.respondText(hash)
    }
}
