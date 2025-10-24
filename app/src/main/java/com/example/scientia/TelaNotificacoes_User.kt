package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TelaNotificacoes_User : Fragment() {
    private val CONTAINER_ID = R.id.containerFrameLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_notificacoes__user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.BarraNavegacaoNotificacoLivro_User)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.notificacoes)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val notificacoesUser = listOf(
            Notificacao(
                R.drawable.capa_ciencia_computacao,
                "Devolução Atrasada",
                "Prazo Expirado."),
            Notificacao(
                R.drawable.capa_matematica_discreta,
                "Devolução concluida.",
                "Você devolveu o livro com sucesso."
            )
        )
    }


}