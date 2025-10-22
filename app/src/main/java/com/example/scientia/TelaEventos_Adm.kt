package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.activity.addCallback
import androidx.appcompat.widget.PopupMenu
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class TelaEventos_Adm : Fragment() {

    private val CONTAINER_ID = R.id.containerFrameLayout
    private lateinit var cardEvento: CardView
    private lateinit var viewModel: EventosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_evento__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa a ViewModel manualmente
        viewModel = ViewModelProvider(requireActivity())[EventosViewModel::class.java]

        val toolbar = view.findViewById<Toolbar>(R.id.toolbarEvento)
        toolbar.setNavigationOnClickListener {
            // Vai direto para a TelaHome ao clicar no botão da Toolbar
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaHome_Adm())
                .commit()
        }

        // Intercepta o botão físico de voltar
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaHome_Adm())
                .commit()
        }

        val cardAdicionar = view.findViewById<CardView>(R.id.cardAdicionarEvento)
        cardAdicionar.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaPerfil_Adm())
                .addToBackStack("adicionar_evento")
                .commit()
        }

        val btnAdd = view.findViewById<ImageButton>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaPerfil_Adm())
                .addToBackStack("adicionar_evento")
                .commit()
        }

        cardEvento = view.findViewById(R.id.cardEvento)

        // Esconde o card se já tiver sido excluído
        if (viewModel.eventoExcluido) {
            cardEvento.visibility = View.GONE
        } else {
            cardEvento.setOnClickListener {
                parentFragmentManager.beginTransaction()
                    .replace(CONTAINER_ID, TelaVisualizarEvento_Adm())
                    .addToBackStack("visualizar_evento")
                    .commit()
            }
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
        val parentView = cardEvento.parent as? ViewGroup
        parentView?.removeView(cardEvento)

        // Marca como excluído na ViewModel
        viewModel.eventoExcluido = true
    }
}
