package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar

class TelaEmpRealizados_Adm : Fragment() {
    private lateinit var btnVoltar: MaterialToolbar
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_emp_realizados__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnVoltar = view.findViewById(R.id.BarraNavegacaoLivrosEmpR)

        btnVoltar.setNavigationOnClickListener {
            var intencao = Intent(requireContext(), TelaHome_Adm::class.java)
            startActivity(intencao)
            requireActivity().finish()
        }
    }

}