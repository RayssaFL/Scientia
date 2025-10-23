package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroEmpAdmAdapter(
    private val listaLivrosEmp: List<Livro> ,
    private val onLivroClick: (Livro) -> Unit) :
    RecyclerView.Adapter<LivroEmpAdmAdapter.LivroViewHolder>() {

    inner class LivroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagemCapa: ImageView = itemView.findViewById(R.id.imgCapaLivroEmp)
        val titulo: TextView = itemView.findViewById(R.id.tvTituloLivroEmp)
        val autor: TextView = itemView.findViewById(R.id.tvAutorLivroEmp)
        val cardItem: View = itemView.findViewById(R.id.cardItemEmp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_livro_emp, parent, false)
        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = listaLivrosEmp[position]
        holder.imagemCapa.setImageResource(livro.capaResId)
        holder.titulo.text = livro.titulo
        holder.autor.text = livro.autor
        holder.cardItem.setOnClickListener { onLivroClick(livro) }
    }

    override fun getItemCount(): Int = listaLivrosEmp.size

}