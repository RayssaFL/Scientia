package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TelaInfoLivro_Adm : Fragment() {
    private lateinit var btnVoltar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_info_livro__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnVoltar = view.findViewById(R.id.BarraNavegaçãoInfoLivro)

        btnVoltar.setNavigationOnClickListener {
            voltarTelaTotalLivros()
        }

        btnVoltar.setOnMenuItemClickListener { item ->
            if (item.itemId == R.id.action_editar) {
                irTelaEditarLivro()
                true
            } else if (item.itemId == R.id.action_deletar) {
                mostrarPopupDeletar()
                true
            } else {
                false
            }
        }
    }

    private fun mostrarPopupDeletar() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Excluir Livro")
            .setMessage("Você deseja deletar o livro?")
            .setNegativeButton("Não") { dialog, _ ->
                dialog.dismiss()
                Toast.makeText(requireContext(), "Ação cancelada", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Sim") { dialog, _ ->
                dialog.dismiss()
                deletarLivro()
            }
            .show()
    }

    private fun deletarLivro() {
        Toast.makeText(requireContext(), "Livro deletado com sucesso!", Toast.LENGTH_SHORT).show()
        voltarTelaTotalLivros()
    }


    private fun voltarTelaTotalLivros() {
        val intent = Intent(requireContext(), TelaTodosLivros_Adm::class.java)
        startActivity(intent)
    }


    private fun irTelaEditarLivro() {
        val intent = Intent(requireContext(), TelaEditarInfoLivro_Adm::class.java)
        startActivity(intent)
    }
}