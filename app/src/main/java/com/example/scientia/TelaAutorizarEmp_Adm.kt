package com.example.scientia

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class TelaAutorizarEmp_Adm : Fragment() {

    private lateinit var btnCancelar: Button
    private lateinit var btnSalvar: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_autorizar_emp__adm, container, false)

        btnCancelar = view.findViewById(R.id.btnCancelarEdtLivro)
        btnSalvar = view.findViewById(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            Toast.makeText(requireContext(), "Empréstimo Realizado", Toast.LENGTH_SHORT).show()
        }

        btnCancelar.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Deseja Cancelar o Empréstimo?")
                .setPositiveButton("Sim") { dialog, _ ->
                    Toast.makeText(requireContext(), "Empréstimo Cancelado", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                .setNegativeButton("Não", null)
                .show()
        }

        return view
    }
}
