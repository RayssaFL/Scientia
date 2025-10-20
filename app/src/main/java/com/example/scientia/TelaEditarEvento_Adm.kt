package com.example.scientia

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaEditarEvento_Adm : AppCompatActivity() {

    lateinit var btnCancelar: Button
    lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_editar_evento_adm)

        btnCancelar = findViewById(R.id.btnCancelarEvt)
        btnSalvar = findViewById(R.id.btnSalvarEvt)

    }

    override fun onStart() {
        super.onStart()

        btnSalvar.setOnClickListener {
            Toast.makeText(this, "Edição Salva Com Sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(this, "Edição Cancelada", Toast.LENGTH_SHORT).show()
        }

    }
}