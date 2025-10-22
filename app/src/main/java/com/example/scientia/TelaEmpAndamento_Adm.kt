package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaEmpAndamento_Adm : Fragment() {

    private val CONTAINER_ID = R.id.containerFrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_emp_andamento__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbarLivros)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerLivros)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val listaLivros = listOf(
            Livro(
                "Ciências da Computação",
                "Nell Dale / John Lewis",
                R.drawable.capa_ciencia_computacao,
                "Revista e atualizada com as últimas informações de campo, a quarta edição de Ciência da Computação apresenta a história do hardware e do software...",
                "2018",
                quantidadeTotal = 5,
                quantidadeDisponivel = 3
            ),
            Livro(
                "Matemática Discreta",
                "Clifford Sten",
                R.drawable.capa_matematica_discreta,
                "Esta obra aborda conceitos essenciais da matemática discreta...",
                "2015",
                quantidadeTotal = 4,
                quantidadeDisponivel = 1
            ),
            Livro(
                "Computação em Nuvem",
                "Thomas Erl",
                R.drawable.capa_computacao_nuvem,
                "A computação em nuvem tornou-se parte integrante e fundamental da tecnologia da informação...",
                "2020",
                quantidadeTotal = 3,
                quantidadeDisponivel = 1
            )
        )

        recyclerView.adapter = LivroAdapter(listaLivros) { livro ->
            abrirDetalhesLivro(livro)
        }
    }

    private fun abrirDetalhesLivro(livro: Livro) {
        val fragment = TelaInfoLivroAndamento_Adm().apply {
            arguments = Bundle().apply {
                putString("titulo", livro.titulo)
                putString("autor", livro.autor)
                putString("descricao", livro.descricao)
                putString("ano", livro.ano)
                putInt("capa", livro.capaResId)
                putInt("quantidadeTotal", livro.quantidadeTotal)
                putInt("quantidadeDisponivel", livro.quantidadeDisponivel)
            }
        }

        parentFragmentManager.beginTransaction()
            .replace(CONTAINER_ID, fragment)
            .addToBackStack("info_livro")
            .commit()
    }
}
