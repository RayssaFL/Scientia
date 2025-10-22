package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar

class TelaEmpRealizados_Adm : Fragment() {

    private lateinit var btnVoltar: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_emp_realizados__adm, container, false)

        btnVoltar = view.findViewById(R.id.BarraNavegacaoLivrosEmpR)

        btnVoltar.setNavigationOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        })

        return view
    }

}