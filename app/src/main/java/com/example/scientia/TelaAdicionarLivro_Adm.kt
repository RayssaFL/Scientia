package com.example.scientia

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class TelaAdicionarLivro_Adm : Fragment() {
    private lateinit var imgCapa: ImageView
    private var selecionarImgUri: Uri? = null
    private var verImgCapa: ImageView? = null
    private val PICK_IMAGE_REQUEST = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_adicionar_livro__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgCapa = view.findViewById(R.id.imgCapa)

        view.findViewById<Button>(R.id.btnConfirmar).setOnClickListener {
            Toast.makeText(requireContext(), "Livro adicionado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.btnCancelar).setOnClickListener {
            Toast.makeText(requireContext(), "Ação cancelada", Toast.LENGTH_SHORT).show()
        }
        imgCapa.setOnClickListener {
            abrirPopupUpload()
        }
    }

    private fun abrirPopupUpload() {
        val dialog = Dialog(requireContext())
        val popupView = layoutInflater.inflate(R.layout.popup_upload_capa, null)
        dialog.setContentView(popupView)

        verImgCapa = popupView.findViewById(R.id.imgUpload)
        val btnSalvar = popupView.findViewById<Button>(R.id.btnSalvarPopup)
        val btnCancelar = popupView.findViewById<Button>(R.id.btnCancelarPopup)

        verImgCapa?.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        btnSalvar.setOnClickListener {
            if (selecionarImgUri != null) {
                imgCapa.setImageURI(selecionarImgUri)
                Toast.makeText(requireContext(), "Capa atualizada", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Nenhuma imagem selecionada", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(requireContext(), "Ação cancelada", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && data != null && data.data != null) {
            selecionarImgUri = data.data
            verImgCapa?.setImageURI(selecionarImgUri)
        }
    }
}