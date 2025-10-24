package com.example.scientia

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val fragment: Fragment) :
    ListAdapter<BookFull, BookAdapter.BookVH>(DIFF) {

    companion object {
        private val DIFF = object : DiffUtil.ItemCallback<BookFull>() {
            override fun areItemsTheSame(old: BookFull, new: BookFull) = old.id == new.id
            override fun areContentsTheSame(old: BookFull, new: BookFull) = old == new
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookVH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book_horizontal, parent, false) // usar novo layout
        return BookVH(v)
    }

    override fun onBindViewHolder(holder: BookVH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BookVH(v: View) : RecyclerView.ViewHolder(v) {
        private val image: ImageView = v.findViewById(R.id.imgCapa)
        private val btnInfo: ImageButton = v.findViewById(R.id.btnInfo)
        private val btnMenu: ImageButton = v.findViewById(R.id.btnMenu)

        fun bind(item: BookFull) {
            image.setImageResource(item.coverResId)

            itemView.setOnClickListener {
                abrirDetalhes(item)
            }

            btnInfo.setOnClickListener {
                abrirDetalhes(item)
            }

            btnMenu.setOnClickListener {
                AlertDialog.Builder(fragment.requireContext())
                    .setTitle("Deletar livro")
                    .setMessage("Deseja realmente deletar '${item.title}'?")
                    .setPositiveButton("Sim") { dialog, _ ->
                        val currentList = currentList.toMutableList()
                        currentList.removeAt(adapterPosition)
                        submitList(currentList)
                        dialog.dismiss()
                    }
                    .setNegativeButton("Não") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }

        private fun abrirDetalhes(item: BookFull) {
            val bundle = Bundle()
            bundle.putSerializable("book", item)
            val fragmentDetail = BookDetailsFragment()
            fragmentDetail.arguments = bundle
            fragment.parentFragmentManager.beginTransaction()
                .replace(R.id.containerFrameLayout, fragmentDetail)
                .addToBackStack(null)
                .commit()
        }
    }
}
