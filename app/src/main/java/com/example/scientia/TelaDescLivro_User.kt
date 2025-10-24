package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar

class TelaDescLivro_User : Fragment() {
    private lateinit var btnBarranavUser: MaterialToolbar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_tela_desc_livro__user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnBarranavUser = view.findViewById(R.id.BarraNavegacaoInfoLivro_User)

        btnBarranavUser.setNavigationOnClickListener(object : OnClickListener {
            override fun onClick(v: View?) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            }
        })
    }

}