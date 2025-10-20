package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class TelaEventos_User : AppCompatActivity() {

    lateinit var Card: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_eventos_user)

        Card = findViewById(R.id.cardEvent)

    }

    override fun onStart() {
        super.onStart()

        Card.setOnClickListener {
            val intent = Intent(this, TelaVisualizarEventos_User::class.java)
            startActivity(intent)
        }
    }
}