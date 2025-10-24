package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar

class TelaPerfil_User : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tela_perfil__user, container, false)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.BarraNavegaçãoPerfil)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }

}