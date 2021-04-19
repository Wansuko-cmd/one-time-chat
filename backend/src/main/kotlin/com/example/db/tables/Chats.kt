package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Chats : IntIdTable() {
    val content = varchar("content", 2055)
    val roomId = integer("room_id")
    val userId = integer("user_id")
}
