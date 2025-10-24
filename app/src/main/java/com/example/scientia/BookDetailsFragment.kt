package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar

class BookDetailsFragment : Fragment() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var imgCapa: ImageView
    private lateinit var tvNomeLivro: TextView
    private lateinit var tvAutor: TextView
    private lateinit var tvAno: TextView
    private lateinit var tvIdLivro: TextView
    private lateinit var livroDescricao: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_book_details_with_toolbar, container, false)

        toolbar = v.findViewById(R.id.BarraNavegaçãoInfoLivro)
        imgCapa = v.findViewById(R.id.capaLivro)
        tvNomeLivro = v.findViewById(R.id.tvNomeLivro)
        tvAutor = v.findViewById(R.id.tvAutor)
        tvAno = v.findViewById(R.id.tvAno)
        tvIdLivro = v.findViewById(R.id.tvIdLivro)
        livroDescricao = v.findViewById(R.id.livroDescricao)

        toolbar.setNavigationOnClickListener {
            parentFragmentManager.popBackStack()
        }

        val book = arguments?.getSerializable("book") as? BookFull
        book?.let {
            toolbar.title = it.title
            imgCapa.setImageResource(it.coverResId)
            tvNomeLivro.text = it.title
            tvAutor.text = it.author
            tvAno.text = it.year.toString()
            tvIdLivro.text = "ID: ${it.id}"
            livroDescricao.text = it.description
        }

        return v
    }
}
