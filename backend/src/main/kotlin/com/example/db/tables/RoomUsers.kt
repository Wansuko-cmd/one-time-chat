package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object RoomUsers : IntIdTable() {
    val roomId = integer("room_id")
    val userId = integer("user_id")
}
