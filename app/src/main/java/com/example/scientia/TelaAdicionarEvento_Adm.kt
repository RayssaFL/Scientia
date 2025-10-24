package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment

class TelaAdicionarEvento_Adm : Fragment() {

    private lateinit var btnCancelar: Button
    private lateinit var btnSalvar: Button
    private lateinit var timePicker: TimePicker

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_adicionar_evento__adm, container, false)

        btnCancelar = view.findViewById(R.id.btnCancelarEvt)
        btnSalvar = view.findViewById(R.id.btnSalvarEvt)
        timePicker = view.findViewById(R.id.timePicker)

        timePicker.setIs24HourView(false) // ou true, se quiser formato 24h


        btnSalvar.setOnClickListener {
            Toast.makeText(requireContext(), "Evento Salvo Com Sucesso!", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            Toast.makeText(requireContext(), "Adição de Evento Cancelada", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
