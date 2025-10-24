package com.example.scientia

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TelaRedefinirSenha_User : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var btnrs: Button
    private lateinit var btnV: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_redefinir_senha_user)

        email = findViewById(R.id.emailBuscaUser)
        btnrs = findViewById(R.id.buttonRedSenhaUser)
        btnV = findViewById(R.id.bottonVoltar)

    }

    override fun onStart() {
        super.onStart()
        btnrs.setOnClickListener {
            validarEmail()
        }
        btnV.setOnClickListener {
            voltar()
        }
    }

    private fun validarEmail() {
        val emailTexto = email.text.toString().trim()

        if (emailTexto.isEmpty()) {
            Toast.makeText(this, "Preencha o campo", Toast.LENGTH_SHORT).show()
        }
        else if (emailTexto == "123@gmail.com") {
            mostrarPopupLinkEnviado()
        }
        else {
            Toast.makeText(this, "E-mail Inválido", Toast.LENGTH_SHORT).show()
        }
    }

    private fun mostrarPopupLinkEnviado() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Recuperação de Senha")
            .setMessage("Link enviado para o seu endereço de email!")
            .setPositiveButton("Voltar") { dialog, _ ->
                dialog.dismiss()
                val intent = Intent(this, TelaLogin_User::class.java)
                startActivity(intent)
                finish()
            }
            .show()
    }
    private fun voltar(){
        var arrowback = Intent(this, TelaLogin_User::class.java)
        startActivity(arrowback)
    }
}