package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Rooms : IntIdTable() {
    val hash = varchar("hash", 255)
    val password = varchar("password", 255)
}
