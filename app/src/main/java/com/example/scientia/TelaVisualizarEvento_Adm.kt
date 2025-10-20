package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.scientia.R

class TelaVisualizarEvento_Adm : Fragment() {

    private val CONTAINER_ID = R.id.container

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_visualizar_evento__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.toolbarVisualizar)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }
}
