package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar

class TelaPerfil_Adm : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_perfil__adm, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val toolbar = view.findViewById<MaterialToolbar>(R.id.BarraNavegaçãoPerfil)
        toolbar.setNavigationOnClickListener {
            val fragmentHome = TelaHome_Adm()
            parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, fragmentHome)
                .addToBackStack(null)
                .commit()
        }

    }
}