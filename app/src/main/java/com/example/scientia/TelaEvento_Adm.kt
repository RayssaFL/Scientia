package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import android.widget.Toast


class TelaEvento_Adm : Fragment() {

    private val CONTAINER_ID = R.id.container
    private lateinit var cardEvento: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_evento__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarEvento)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val cardAdicionar = view.findViewById<CardView>(R.id.cardAdicionarEvento)
        cardAdicionar.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, FragTelaAdicionarEvento_Adm())
                .addToBackStack("adicionar_evento")
                .commit()
        }

        val btnAdd = view.findViewById<ImageButton>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, FragTelaAdicionarEvento_Adm(), null)
                .addToBackStack("adicionar_evento")
                .commit()
        }

        cardEvento = view.findViewById(R.id.cardEvento)
        cardEvento.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaVisualizarEvento_Adm())
                .addToBackStack("visualizar_evento")
                .commit()
        }

        val btnMenu = view.findViewById<ImageButton>(R.id.menuEvento)
        btnMenu.setOnClickListener { v ->
            val popup = PopupMenu(requireContext(), v)
            popup.menuInflater.inflate(R.menu.menu_evento, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_editar -> {
                        parentFragmentManager.beginTransaction()
                            .replace(CONTAINER_ID, TelaEmpAndamento_Adm())
                            .addToBackStack("editar_evento")
                            .commit()
                        true
                    }
                    R.id.menu_excluir -> {
                        excluirCard()
                        Toast.makeText(requireContext(), "Evento Deletado", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }

    private fun excluirCard() {
        val parentView = cardEvento.parent as ViewGroup
        parentView?.removeView(cardEvento)
    }
}
