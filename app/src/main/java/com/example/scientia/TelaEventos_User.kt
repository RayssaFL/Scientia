package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar

class TelaEventos_User : Fragment() {

    private val CONTAINER_ID = R.id.containerFrameLayout
    private lateinit var cardEvento: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_eventos__user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbarEvento)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaHome_User())
                .commit()
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaHome_User())
                .commit()
        }

        cardEvento = view.findViewById(R.id.cardEvento)
        cardEvento.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(CONTAINER_ID, TelaVisualizarEventos_User())
                .addToBackStack("visualizar_evento")
                .commit()
        }
    }
}
