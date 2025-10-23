package com.example.scientia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaLogin_Adm : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var senha: EditText
    lateinit var btnEntrar: Button
    lateinit var esqueceuSenha: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_login_adm)
        email = findViewById(R.id.emailLoginAdm)
        senha = findViewById(R.id.senhaLoginAdm)
        esqueceuSenha = findViewById(R.id.esqueceuSenhaLoginAdm)
        btnEntrar = findViewById(R.id.entrarLoginAdm)
    }

    override fun onStart() {
        super.onStart()
        super.onStart()
        btnEntrar.setOnClickListener {
            validarCadastro()
        }
        esqueceuSenha.setOnClickListener {
            val intencao = Intent(this, TelaRedefinirSenha_Adm::class.java)
            startActivity(intencao)
        }
    }
    private fun validarCadastro(){
        if(email.text.toString() == "oioioi@gmail.com" && senha.text.toString() == "1234"){
            val toastEntrar = Toast.makeText(this, "Entrada Autorizada", Toast.LENGTH_SHORT)
            toastEntrar.show()
            val intencao = Intent(this, TelaBarraFixa_Adm::class.java)
            startActivity(intencao)
        } else if(email.text.isEmpty() || senha.text.isEmpty()){
            val toastCampoVazio = Toast.makeText(this, "Preencha Todos os Campos", Toast.LENGTH_SHORT)
            toastCampoVazio.show()
        }else{
            val toastDadosIncorretos = Toast.makeText(this, "Email ou Senha Incorretos", Toast.LENGTH_SHORT)
            toastDadosIncorretos.show()
        }

    }
}