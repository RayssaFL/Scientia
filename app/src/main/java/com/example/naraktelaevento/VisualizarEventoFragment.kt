package com.example.naraktelaevento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class VisualizarEventoFragment : Fragment() {

    // Container principal da MainActivity
    private val CONTAINER_ID = R.id.container

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_visualizar_evento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura toolbar azul com botão de voltar
        val toolbar = view.findViewById<Toolbar>(R.id.toolbarVisualizar)
        toolbar.setNavigationOnClickListener {
            // Volta para a tela anterior
            parentFragmentManager.popBackStack()
        }

        // Se quiser, você pode adicionar cliques em cards aqui
        // Exemplo: abrir um diálogo ou outra tela
    }
}
