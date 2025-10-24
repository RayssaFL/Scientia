package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class TelaEmpRealizados_Adm : Fragment() {

    private lateinit var btnVoltar: MaterialToolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LivroEmpAdmAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_emp_realizados__adm, container, false)

        btnVoltar = view.findViewById(R.id.BarraNavegacaoLivrosEmpR)
        recyclerView = view.findViewById(R.id.recyclerEmpRest)

        btnVoltar.setNavigationOnClickListener {
            val fragmentHome = TelaHome_Adm()
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, fragmentHome)
                .addToBackStack(null)
                .commit()
        }
        val listaLivrosEmp = listOf(
            LivroEmp("Álgebra Linear", "Howard Anton", R.drawable.capa_computacao_nuvem, "Livro sobre vetores e matrizes", "2010",2535, 10, 2),
            LivroEmp("Projetos de Banco de Dados", "Howard", R.drawable.capa, "Fantasia épica", "1954", 53453,4, 1),
            LivroEmp("Clean Code", "Robert C. Martin", R.drawable.capa, "Boas práticas de programação", "2008", 335454,1, 0)
        )
        adapter = LivroEmpAdmAdapter(listaLivrosEmp){
            livroSel -> abrirInfoLivro(livroSel)
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }
    private fun abrirInfoLivro(livro: LivroEmp) {
        val fragmentInfo = TelaInfoLivro_Adm()
        val bundle = Bundle().apply {
            putString("titulo", livro.tituloE)
            putString("autor", livro.autorE)
            putString("descricao", livro.descricaoE)
            putString("ano", livro.anoE)
            putInt("id", livro.idE)
            putInt("capa", livro.capaResIdE)
            putInt("quantidadeTotal", livro.quantidadeTotalE)
            putInt("quantidadeDisponivel", livro.quantidadeDisponivelE)
        }
        fragmentInfo.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.containerFrameLayout, fragmentInfo)
            .addToBackStack("info_livro")
            .commit()
    }

}