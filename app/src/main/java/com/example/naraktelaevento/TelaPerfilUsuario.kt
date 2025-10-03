package com.example.naraktelaevento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class TelaPerfilUsuario : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tela_perfil_usuario, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nomeUsuario = "Laura Rejane"
        val inicial = nomeUsuario.firstOrNull()?.toString() ?: "?"

        view.findViewById<TextView>(R.id.avatar).text = inicial
        view.findViewById<TextView>(R.id.nomeUsuario).text = nomeUsuario
        view.findViewById<TextView>(R.id.idUsuario).text = "1205468"
        view.findViewById<TextView>(R.id.emailUsuario).text = "lrejane23@gmail.com"
        view.findViewById<TextView>(R.id.idUsuarioDetalhe).text = "ID: 1205468"

        // Botão voltar funcional
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack() // volta ao fragment anterior
        }
    }
}
