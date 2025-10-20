package com.example.scientia

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class TelaAutorizarEmp_Adm : AppCompatActivity() {

    lateinit var btnCancelar: Button
    lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_autorizar_emp_adm)

        btnCancelar = findViewById(R.id.btnCancelarEdtLivro)
        btnSalvar = findViewById(R.id.btnSalvar)
    }

    override fun onStart() {
        super.onStart()

        btnSalvar.setOnClickListener {
            Toast.makeText(this, "Empréstimo Realizado", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Deseja Cancelar o Empréstimo?")
                .setPositiveButton("Sim") { dialog, _ ->
                    Toast.makeText(this, "Empréstimo Cancelado", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setNegativeButton("Não", null)
                .show()
        }

    }
}