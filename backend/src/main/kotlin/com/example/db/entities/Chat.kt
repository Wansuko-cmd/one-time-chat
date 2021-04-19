package com.example.db.entities

import com.example.db.tables.Chats
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Chat(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Chat>(Chats)

    var content by Chats.content
    var roomId by Chats.roomId
    var userId by Chats.userId
}
