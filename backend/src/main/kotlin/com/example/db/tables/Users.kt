package com.example.db.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Users: IntIdTable() {
    val name = varchar("name", 50)
    val imagePath = varchar("image_path", 255)
}
