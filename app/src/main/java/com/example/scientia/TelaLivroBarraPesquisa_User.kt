package com.example.scientia

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaLivroBarraPesquisa_User : Fragment() {

    private val CONTAINER_ID = R.id.containerFrameLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: LivroAdapter
    private lateinit var listaOriginal: List<Livro>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_livro_barra_pesquisa__user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.notificacoes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbarLivrosTotaisPesquisa)
        toolbar.setNavigationOnClickListener { parentFragmentManager.popBackStack() }

        val searchView = view.findViewById<SearchView>(R.id.searchViewLivrosPesquisa)
        searchView.setOnClickListener {
            searchView.isIconified = false
            searchView.requestFocus()
            val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(searchView.findFocus(), InputMethodManager.SHOW_IMPLICIT)
        }

        listaOriginal = listOf(
            Livro("Ciências da Computação", "Nell Dale / John Lewis", R.drawable.capa_computacao_nuvem,
                "Descrição detalhada...", "2018", 43543, 5, 3),
            Livro("Matemática Discreta", "Clifford Sten", R.drawable.capa_computacao_nuvem,
                "Descrição detalhada...", "2015", 23322, 4, 1),
            Livro("Computação em Nuvem", "Thomas Erl", R.drawable.capa_computacao_nuvem,
                "Descrição detalhada...", "2020", 34324, 3, 1)
        )

        adapter = LivroAdapter(listaOriginal) { livro -> abrirDetalhesLivro(livro) }
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false
            override fun onQueryTextChange(newText: String?): Boolean {
                filtrarLista(newText ?: "")
                return true
            }
        })
    }

    private fun filtrarLista(query: String) {
        val listaFiltrada = if (query.isEmpty()) listaOriginal
        else listaOriginal.filter { it.titulo.contains(query, ignoreCase = true) }
        adapter.updateList(listaFiltrada)
    }

    private fun abrirDetalhesLivro(livro: Livro) {
        val fragment = TelaInfoLivro_Adm()
        val bundle = Bundle().apply {
            putString("titulo", livro.titulo)
            putString("autor", livro.autor)
            putString("descricao", livro.descricao)
            putString("ano", livro.ano)
            putInt("capa", livro.capaResId)
            putInt("quantidadeTotal", livro.quantidadeTotal)
            putInt("quantidadeDisponivel", livro.quantidadeDisponivel)
        }
        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(CONTAINER_ID, fragment)
            .addToBackStack("info_livro")
            .commit()
    }
}
