package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroAvaliacoesAdapter (
    private val listaLivrosAvaliacoesUser: List<LivroAvaliacoes> ,
    private val onLivroAvaliacoesClick: (LivroAvaliacoes) -> Unit) :
    RecyclerView.Adapter<LivroAvaliacoesAdapter.LivroAvaliacoesViewHolder>() {

    inner class LivroAvaliacoesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagemCapa: ImageView = itemView.findViewById(R.id.imgCapaLivroEmp)
        val titulo: TextView = itemView.findViewById(R.id.tvTituloLivroEmp)
        val autor: TextView = itemView.findViewById(R.id.tvAutorLivroEmp)
        val cardItem: View = itemView.findViewById(R.id.cardItemEmp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroAvaliacoesViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_livro_emp, parent, false)
        return LivroAvaliacoesViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroAvaliacoesViewHolder, position: Int) {
        val livroAvaliacoes = listaLivrosAvaliacoesUser[position]
        holder.imagemCapa.setImageResource(livroAvaliacoes.capaResIdAv)
        holder.titulo.text = livroAvaliacoes.tituloAv
        holder.autor.text = livroAvaliacoes.autorAv
        holder.cardItem.setOnClickListener { onLivroAvaliacoesClick(livroAvaliacoes) }
    }

    override fun getItemCount(): Int = listaLivrosAvaliacoesUser.size

}