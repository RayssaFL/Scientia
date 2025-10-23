package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class TelaInfoLivro_Adm : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_info_livro__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.BarraNavegaçãoInfoLivro)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val titulo = arguments?.getString("titulo") ?: ""
        val autor = arguments?.getString("autor") ?: ""
        val descricao = arguments?.getString("descricao") ?: ""
        val ano = arguments?.getString("ano") ?: ""
        val capaResId = arguments?.getInt("capa") ?: 0
        val quantidadeTotal = arguments?.getInt("quantidadeTotal") ?: 0
        val quantidadeDisponivel = arguments?.getInt("quantidadeDisponivel") ?: 0

        val tvNomeLivro = view.findViewById<TextView>(R.id.tvNomeLivro)
        val tvAutor = view.findViewById<TextView>(R.id.tvAutor)
        val tvAno = view.findViewById<TextView>(R.id.tvAno)
        val tvIdLivro = view.findViewById<TextView>(R.id.tvIdLivro)
        val livroDescricao = view.findViewById<TextView>(R.id.livroDescricao)
        val capaLivro = view.findViewById<ImageView>(R.id.capaLivro)

        val qtdTotal = view.findViewById<TextView>(R.id.qtdTotal)
        val qtdDisp = view.findViewById<TextView>(R.id.qtdDisp)

        tvNomeLivro.text = titulo
        tvAutor.text = autor
        tvAno.text = ano
        tvIdLivro.text = "ID: ${arguments?.getInt("id") ?: 0}"
        livroDescricao.text = descricao
        capaLivro.setImageResource(capaResId)

        qtdTotal.text = "Quantidade Total: $quantidadeTotal"
        qtdDisp.text = "Quantidade Disponível: $quantidadeDisponivel"
    }
}
