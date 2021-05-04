package com.example.routes.chat

import kotlinx.serialization.Serializable

@Serializable
data class Content(
    val id: String,
    val content: String
)
