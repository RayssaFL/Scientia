package com.example.scientia

import java.io.Serializable

data class Usuario(
    val nome: String,
    val dataEmprestimo: String,
    val dataDevolucao: String
) : Serializable
