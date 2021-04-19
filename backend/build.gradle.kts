val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val exposedVersion: String by project
val hikariVersion: String by project
val postgresqlVersion: String by project
val flywayVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.4.32"
}

group = "com.example"
version = "0.0.1"
val mainClassName = "io.ktor.server.netty.EngineMain"

application {
    mainClass.set("com.example.ApplicationKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    //exposed
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")

    //hikari
    implementation("com.zaxxer:HikariCP:$hikariVersion")

    //hikari用のpostgresのドライバー
    implementation("org.postgresql:postgresql:$postgresqlVersion")

    //flyway
    implementation("org.flywaydb:flyway-core:$flywayVersion")

    //WebSocket
    implementation("io.ktor:ktor-websockets:$ktorVersion")
}
