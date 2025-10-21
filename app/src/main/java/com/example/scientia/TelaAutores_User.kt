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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_autores__user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbarS = view.findViewById<MaterialToolbar>(R.id.toolbarAutores)
        toolbarS.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val recycler = view.findViewById<RecyclerView>(R.id.recyclerAutores)
        recycler.layoutManager = LinearLayoutManager(requireContext())

        val listaAutores = listOf(
            Autores("Carlos Alberto"),
            Autores("Jose Souza"),
            Autores("Maria Silva"),
            Autores("Ana Santos")
        )

//        recycler.adapter = AutoresListaAdapter(listaAutores) { autores ->
//            abrirPerfil(autores)
//        } /////REATIVAR QUANDO TIVER A TELA DE PERFIL DO AUTOR!!!!!!!
    }

//    private fun abrirPerfil(autores: Autores) {
//        val fragment = TelaPerfilAutor_User()
//        val bundle = Bundle()
//        bundle.putString("nome", autores.nome)
//        fragment.arguments = bundle
//
//        parentFragmentManager.beginTransaction()
//            .replace(R.id.container, fragment)
//            .addToBackStack("perfil_usuario")
//            .commit()
//            }

}