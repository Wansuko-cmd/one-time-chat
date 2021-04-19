package com.example.db.entities

import com.example.db.tables.Users
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class User(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<User>(Users)

    var name by Users.name
    var imagePath by Users.imagePath
    var email by Users.email
    var password by Users.password
}
