package com.example.scientia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaLogin_User : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var senha: EditText
    lateinit var btnEntrar: Button
    lateinit var esqueceuSenha: TextView
    lateinit var cadastrar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_login_user)

        email = findViewById(R.id.EmailUser)
        senha = findViewById(R.id.SenhaUser)
        btnEntrar = findViewById(R.id.ButtonEntrarUser)
        esqueceuSenha = findViewById(R.id.EsqueceuSenhaUser)
        cadastrar = findViewById(R.id.CadastrarUser)
    }

    override fun onStart() {
        super.onStart()

        btnEntrar.setOnClickListener {
            validarLogin()
        }

        esqueceuSenha.setOnClickListener {
            val intencao = Intent(this, TelaRedefinirSenha_User::class.java)
            startActivity(intencao)
        }

        cadastrar.setOnClickListener {
            val intenc = Intent(this, TelaCadastro_User::class.java)
            startActivity(intenc)
        }
    }

    private fun validarLogin() {
        if (email.text.toString() == "123@gmail.com" && senha.text.toString() == "1234") {
            Toast.makeText(this, "Entrada Autorizada", Toast.LENGTH_SHORT).show()
            val intencao = Intent(this, TelaBarraFixa_User::class.java)
            startActivity(intencao)
            finish()
        } else if (email.text.isEmpty() || senha.text.isEmpty()) {
            Toast.makeText(this, "Preencha Todos os Campos", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Email ou Senha Incorretos", Toast.LENGTH_SHORT).show()
        }
    }
}
