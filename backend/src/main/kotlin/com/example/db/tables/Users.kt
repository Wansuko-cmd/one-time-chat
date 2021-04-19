package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {
    val name = varchar("name", 255)
    val imagePath = varchar("image_path", 255)
    val email = varchar("email", 255)
    val password = varchar("password", 255)
}
