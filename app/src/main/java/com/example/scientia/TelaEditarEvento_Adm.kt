package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class TelaEditarEvento_Adm : Fragment() {

    private lateinit var btnCancelar: Button
    private lateinit var btnSalvar: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_editar_evento__adm, container, false)

        btnCancelar = view.findViewById(R.id.btnCancelarEvt)
        btnSalvar = view.findViewById(R.id.btnSalvarEvt)

        btnSalvar.setOnClickListener {
            Toast.makeText(requireContext(), "Edição Salva Com Sucesso! ", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(requireContext(), "Edição Cancelada ", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
