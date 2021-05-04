package com.example.routes.chat

import com.example.db.entities.Room
import com.example.db.tables.Rooms
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.http.cio.websocket.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.websocket.*
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import kotlin.collections.LinkedHashSet
import kotlin.properties.Delegates

fun Route.chatRoutes(){

    val connections = Collections.synchronizedSet<Connection?>(LinkedHashSet())

    get("/chat") {

        var newHash = ""
        var isExist = true

        //ユニークなチャット部屋ハッシュであることを検証
        while(isExist){
            newHash = UUID.randomUUID().toString()

            transaction {
                isExist = Room.find { Rooms.hash eq newHash }.count() <= 0
            }
        }

        transaction {
            Rooms.insert {
                it[hash] = newHash
            }
        }

        call.respondText(newHash)
    }

    webSocket("/chat/{hash}") {
        val hash = call.parameters["hash"] ?: return@webSocket call.respondText("Bad Request", status = HttpStatusCode.BadRequest)

        val thisConnection = Connection(this, "name", hash)
        connections += thisConnection

        try{
            send("You are connected! There are ${connections.count()} users here.")
            for (frame in incoming){
                frame as? Frame.Text ?: continue
                val receivedText = frame.readText()
                val textWithUserName = "[${thisConnection.name}]: $receivedText"
                connections.forEach{
                    it.session.send(textWithUserName)
                }
            }
        }catch (e: Exception){
            println(e.localizedMessage)
        }finally {
            println("Removing $thisConnection!")
            connections -= thisConnection
        }

//        try{
//            send(hash)
//        }catch (e: Exception){
//            return@webSocket call.respondText("Bad Request", status = HttpStatusCode.BadRequest)
//        }
    }
}
