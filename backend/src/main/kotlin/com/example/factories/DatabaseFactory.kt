package com.example.factories

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.config.*
import org.jetbrains.exposed.sql.Database

object DatabaseFactory {

    private val appConfig = HoconApplicationConfig(ConfigFactory.load())
    private val driverClass = appConfig.property("db.driverClass").getString()
    private val dbUrl = appConfig.property("db.url").getString()
    private val dbUser = appConfig.property("db.user").getString()
    private val dbPassword = appConfig.property("db.password").getString()

    fun init(){
        Database.connect(hikari())
    }

    private fun hikari(): HikariDataSource{
        val config = HikariConfig().apply {
            driverClassName = driverClass
            jdbcUrl = dbUrl
            username = dbUser
            password = dbPassword
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(config)
    }
}
