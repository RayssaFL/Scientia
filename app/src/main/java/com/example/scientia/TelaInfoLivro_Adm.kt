package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TelaInfoLivro_Adm : Fragment() {
    private lateinit var btnVoltar: MaterialToolbar
    private lateinit var imgCapa: ImageView
    private lateinit var txtTitulo: TextView
    private lateinit var txtAutor: TextView
    private lateinit var txtDescricao: TextView
    private lateinit var txtAno: TextView
    private lateinit var txtID: TextView
    private lateinit var txtQtdTotal: TextView
    private lateinit var txtQtdDisp: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_info_livro__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnVoltar = view.findViewById(R.id.BarraNavegaçãoInfoLivro)
        imgCapa = view.findViewById(R.id.capaLivro)
        txtTitulo = view.findViewById(R.id.tvNomeLivro)
        txtAutor = view.findViewById(R.id.tvAutor)
        txtDescricao = view.findViewById(R.id.livroDescricao)
        txtAno = view.findViewById(R.id.tvAno)
        txtID = view.findViewById(R.id.tvIdLivro)
        txtQtdTotal = view.findViewById(R.id.tot)
        txtQtdDisp = view.findViewById(R.id.disp)

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
        val args = arguments
        args?.let {
            val titulo = it.getString("titulo")
            val autor = it.getString("autor")
            val descricao = it.getString("descricao")
            val ano = it.getString("ano")
            val id = it.getInt("id")
            val capa = it.getInt("capa")
            val qtdTotal = it.getInt("quantidadeTotal")
            val qtdDisp = it.getInt("quantidadeDisponivel")

            // 🔹 Preencher na tela
            imgCapa.setImageResource(capa)
            txtTitulo.text = titulo
            txtAutor.text = autor
            txtDescricao.text = descricao
            txtAno.text = "Ano: $ano"
            txtID.text = "ID: $id"
            txtQtdTotal.text = "Total: $qtdTotal"
            txtQtdDisp.text = "Disponível: $qtdDisp"
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
        val fragment = TelaEmpRealizados_Adm()
        parentFragmentManager.beginTransaction()
            .replace(R.id.containerFrameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }


    private fun irTelaEditarLivro() {
        val intent = Intent(requireContext(), TelaEditarInfoLivro_Adm::class.java)
        startActivity(intent)

        //quando for fragment tirar o comentario
//       val fragment2 = TelaEditarInfoLivro_Adm()
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.containerFrameLayout, fragment2)
//            .addToBackStack(null)
//            .commit()
    }
}