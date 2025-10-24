package com.example.scientia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TelaCadastro_User : AppCompatActivity() {

    lateinit var email: EditText
    lateinit var senha: EditText
    lateinit var confirmarSenha: EditText
    lateinit var btnCadastrar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_user)
        email = findViewById(R.id.emailCadastro)
        senha = findViewById(R.id.SenhaCriar)
        confirmarSenha = findViewById(R.id.SenhaConfirm)
        btnCadastrar = findViewById(R.id.ButtonCriarConta)

        btnCadastrar.setOnClickListener {
            compararSenhas()
        }
    }


    private fun compararSenhas() {
        val senhaStr = senha.text.toString()
        val confirmarStr = confirmarSenha.text.toString()

        if (senhaStr.isEmpty() || confirmarStr.isEmpty()) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (senhaStr.length < 6) {
            Toast.makeText(this, "A senha deve ter pelo menos 6 caracteres", Toast.LENGTH_SHORT).show()
            return
        }

        if (senhaStr == confirmarStr) {
            Toast.makeText(this, "Senhas coincidem! Cadastro concluído.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, TelaBarraFixa_User::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "As senhas não coincidem!", Toast.LENGTH_SHORT).show()
        }
    }
}