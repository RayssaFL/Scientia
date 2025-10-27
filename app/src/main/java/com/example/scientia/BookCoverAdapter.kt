package com.example.scientia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class BookCoverAdapter(
    private val fragment: Fragment,
    private val books: List<BookFull>
) : RecyclerView.Adapter<BookCoverAdapter.CoverViewHolder>() {

    inner class CoverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgCapa: ImageView = itemView.findViewById(R.id.imgCapaSimples)

        fun bind(book: BookFull) {
            imgCapa.setImageResource(book.coverResId)
            itemView.setOnClickListener {
                val bundle = Bundle().apply {
                    putSerializable("book", book)
                }
                val fragmentDetail = BookDetailsFragment().apply {
                    arguments = bundle
                }
                fragment.parentFragmentManager.beginTransaction()
                    .replace(R.id.containerFrameLayout, fragmentDetail)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoverViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_capa_livro, parent, false)
        return CoverViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoverViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size
}
