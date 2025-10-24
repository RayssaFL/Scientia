package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.Toolbar

class TelaDescLivroAvaliacoes_User : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_desc_livro_avaliacoes_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.barraNavegacaoDescAvaliacoes)
        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val rating = 3

        val stars = listOf<ImageButton>(
            view.findViewById(R.id.imageButton1),
            view.findViewById(R.id.imageButton2),
            view.findViewById(R.id.imageButton3),
            view.findViewById(R.id.imageButton4),
            view.findViewById(R.id.imageButton5)
        )

        // Fill stars based on rating
        for (i in stars.indices) {
            if (i < rating) {
                stars[i].setImageResource(R.drawable.filled_star)
            } else {
                stars[i].setImageResource(R.drawable.unfilled_star)
            }
        }
    }

}