package com.example.scientia

import java.io.Serializable

data class BookFull(
    val id: Int,
    val title: String,
    val author: String,
    val year: Int,
    val description: String,
    val coverResId: Int
) : Serializable
