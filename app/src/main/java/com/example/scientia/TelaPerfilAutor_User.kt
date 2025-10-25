package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaPerfilAutor_User : Fragment() {

    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_perfil_autor_user, container, false)

        toolbar = view.findViewById(R.id.BarraNavegacaoPerfilAutor)
        recyclerView = view.findViewById(R.id.recyclerViewLivrosAutor)

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        val livrosAutor = listOf(
            BookFull(1, "Cálculo", "Howard Anton", 2024, "Clássico livro de cálculo.", R.drawable.capa),
            BookFull(2, "Álgebra Linear", "Howard Anton", 2023, "Livro sobre álgebra linear.", R.drawable.capa2),
            BookFull(3, "Matemática Aplicada", "Howard Anton", 2022, "Aplicações práticas da matemática.", R.drawable.capa3)
        )

        recyclerView.adapter = BookCoverAdapter(this, livrosAutor)

        return view
    }
}
