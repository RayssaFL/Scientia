package com.example.scientia

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TelaDescLivroAvaliacoes_User.newInstance] factory method to
 * create an instance of this fragment.
 */
class TelaDescLivroAvaliacoes_User : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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

        val toolbar = view.findViewById<com.google.android.material.appbar.MaterialToolbar>(
            R.id.barraNavegacaoDescAvaliacoes
        )

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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TelaDescLivroAvaliacoes_User.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TelaDescLivroAvaliacoes_User().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}