package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroHistoricoUserAdapter(
    private val listaLivrosEmpHistorico: List<LivroHistoricoUser> ,
    private val onLivroHClick: (LivroHistoricoUser) -> Unit) :
    RecyclerView.Adapter<LivroHistoricoUserAdapter.LivroHistoricoViewHolder>() {

    inner class LivroHistoricoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagemCapa: ImageView = itemView.findViewById(R.id.imgCapaLivroEmp)
        val titulo: TextView = itemView.findViewById(R.id.tvTituloLivroEmp)
        val autor: TextView = itemView.findViewById(R.id.tvAutorLivroEmp)
        val cardItem: View = itemView.findViewById(R.id.cardItemEmp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroHistoricoViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_livro_emp, parent, false)
        return LivroHistoricoViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroHistoricoViewHolder, position: Int) {
        val livroHistoricoUser = listaLivrosEmpHistorico[position]
        holder.imagemCapa.setImageResource(livroHistoricoUser.capaResIdU)
        holder.titulo.text = livroHistoricoUser.tituloU
        holder.autor.text = livroHistoricoUser.autorU
        holder.cardItem.setOnClickListener { onLivroHClick(livroHistoricoUser) }
    }

    override fun getItemCount(): Int = listaLivrosEmpHistorico.size

}