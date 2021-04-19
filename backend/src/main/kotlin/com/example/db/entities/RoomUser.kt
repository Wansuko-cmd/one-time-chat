package com.example.db.entities

import com.example.db.tables.RoomUsers
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RoomUser(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomUser>(RoomUsers)

    var roomId = RoomUsers.roomId
    var userId = RoomUsers.userId
}
