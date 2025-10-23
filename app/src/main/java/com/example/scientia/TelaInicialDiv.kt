package com.example.scientia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TelaInicialDiv : AppCompatActivity() {
    lateinit var entrarAdm: Button
    lateinit var entrarUser: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_inicial_div)
        entrarAdm = findViewById(R.id.adm)
        entrarUser = findViewById(R.id.user)
    }

    override fun onStart() {
        super.onStart()
        entrarAdm.setOnClickListener {
            val intencao = Intent(this, TelaLogin_Adm::class.java)
            startActivity(intencao)
        }
        entrarUser.setOnClickListener{
            val intencao = Intent(this, TelaLogin_User::class.java)
            startActivity(intencao)
        }
    }
}