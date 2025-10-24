package com.example.scientia

data class Message(
    val text: String,
    val isUser: Boolean // true = user message, false = bot message
)
