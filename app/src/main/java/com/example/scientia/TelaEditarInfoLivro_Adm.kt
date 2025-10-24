package com.example.scientia

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

class TelaEditarInfoLivro_Adm : Fragment() {

    private lateinit var imgCapa: ImageView
    private lateinit var btnCancelar: Button
    private lateinit var btnSalvar: Button

    private var imagemSelecionada: Uri? = null

    // Registrador para abrir a galeria e receber a imagem escolhida
    private val selecionarImagem = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        if (uri != null) {
            imagemSelecionada = uri
            imgCapa.setImageURI(uri)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_editar_info_livro__adm, container, false)

        imgCapa = view.findViewById(R.id.imgCapa)
        btnCancelar = view.findViewById(R.id.btnCancelarEdtLivro)
        btnSalvar = view.findViewById(R.id.btnConfirmarEdtLivro)

        imgCapa.setOnClickListener {
            val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.upload_simples, null)
            val builder = AlertDialog.Builder(requireContext())
            builder.setView(dialogView)

            val dialog = builder.create()
            dialog.show()

            val btnSalvarDialog = dialogView.findViewById<Button>(R.id.btnSalvar)
            val btnCancelarDialog = dialogView.findViewById<Button>(R.id.btnCancelar)
            val btnUploadImage = dialogView.findViewById<LinearLayout>(R.id.uploadImagem)


            // Quando clicar, abrir galeria
            btnUploadImage.setOnClickListener {
                selecionarImagem.launch("image/*") // abre a galeria
                dialog.dismiss()
            }


            btnSalvarDialog.setOnClickListener {
                Toast.makeText(requireContext(), "Capa Atualizada", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            // Quando clicar em "Cancelar", fechar o diálogo
            btnCancelarDialog.setOnClickListener {
                Toast.makeText(requireContext(), "Ação Cancelada", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
        }

        btnSalvar.setOnClickListener {
            Toast.makeText(requireContext(), "Alterações Realizadas", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(requireContext(), "Ação Cancelada", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
