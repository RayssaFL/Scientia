package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class TelaAutores_User : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_autores__user, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbarAutores)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerAutores)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val listaAutores = listOf(
            Autor("José Almeida"),
            Autor("Ana Maria"),
            Autor("Camila Lima")
        )

        recycler.adapter = AutorAdapter(listaAutores) { autor ->
            abrirPerfil(autor)
        }
    }

    private fun abrirPerfil(autor: Autor) {
        val fragment = TelaPerfilAutor_User()
        val bundle = Bundle()
        bundle.putString("nome", autor.nome)
        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.containerFrameLayout, fragment)
            .addToBackStack("perfil_usuario")
            .commit()
    }
}