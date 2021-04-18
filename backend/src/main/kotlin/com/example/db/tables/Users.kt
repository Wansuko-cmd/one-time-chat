package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Users: IntIdTable() {
    val name = varchar("name", 50)
}
