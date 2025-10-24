package com.example.scientia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.content.Intent

class TelaDescEmpAberto_User : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_desc_emp_aberto_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(
            R.id.barraNavegacaoDescEmpRealizados
        )

        toolbar.setNavigationOnClickListener {
            val intent = Intent(requireContext(), TelaMenu_User::class.java)
            startActivity(intent)
        }

        val stars = listOf(
            view.findViewById<ImageButton>(R.id.imageButton1),
            view.findViewById<ImageButton>(R.id.imageButton2),
            view.findViewById<ImageButton>(R.id.imageButton3),
            view.findViewById<ImageButton>(R.id.imageButton4),
            view.findViewById<ImageButton>(R.id.imageButton5)
        )

        val filledStar = R.drawable.filled_star
        val unfilledStar = R.drawable.unfilled_star

        stars.forEachIndexed {index, button ->
            button.setOnClickListener {
                for (i in stars.indices) {
                    if (i <= index) {
                        stars[i].setImageResource(filledStar)
                    } else {
                        stars[i].setImageResource(unfilledStar)
                    }
                }
            }
        }
    }
}