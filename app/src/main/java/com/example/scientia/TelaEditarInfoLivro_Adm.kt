package com.example.scientia

import android.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TelaEditarInfoLivro_Adm : AppCompatActivity() {

    private lateinit var imgCapa: ImageView
    private lateinit var btnCancelar: Button
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tela_editar_info_livro_adm)

        btnCancelar = findViewById(R.id.btnCancelarEdtLivro)
        btnSalvar = findViewById(R.id.btnConfirmarEdtLivro)
        imgCapa = findViewById(R.id.imgCapa)

    }

    override fun onStart() {
        super.onStart()

        imgCapa.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.upload_simples, null)
            val builder = AlertDialog.Builder(this)
            builder.setView(dialogView)

            val dialog = builder.create()
            dialog.show()

            val btnSalvar = dialogView.findViewById<Button>(R.id.btnSalvar)
            val btnCancelar = dialogView.findViewById<Button>(R.id.btnCancelar)

            btnSalvar.setOnClickListener {
                Toast.makeText(this, "Capa Atualizada", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            btnCancelar.setOnClickListener {
                Toast.makeText(this, "Ação Cancelada", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }


        btnSalvar.setOnClickListener {
            Toast.makeText(this, "Alterações Realizadas", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(this, "Ação Cancelada", Toast.LENGTH_SHORT).show()
        }

    }


}