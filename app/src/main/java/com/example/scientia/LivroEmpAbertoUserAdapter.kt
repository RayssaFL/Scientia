package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroEmpAbertoUserAdapter (
    private val listaLivrosEmpAbertoUser: List<LivroEmpAber_User> ,
    private val onLivroClickAberto: (LivroEmpAber_User) -> Unit) :
    RecyclerView.Adapter<LivroEmpAbertoUserAdapter.LivroEmpAbertoViewHolder>() {

    inner class LivroEmpAbertoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagemCapa: ImageView = itemView.findViewById(R.id.imgCapaLivroEmp)
        val titulo: TextView = itemView.findViewById(R.id.tvTituloLivroEmp)
        val autor: TextView = itemView.findViewById(R.id.tvAutorLivroEmp)
        val cardItem: View = itemView.findViewById(R.id.cardItemEmp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroEmpAbertoViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_livro_emp, parent, false)
        return LivroEmpAbertoViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroEmpAbertoViewHolder, position: Int) {
        val livroempA = listaLivrosEmpAbertoUser[position]
        holder.imagemCapa.setImageResource(livroempA.capaResIdA)
        holder.titulo.text = livroempA.tituloA
        holder.autor.text = livroempA.autorA
        holder.cardItem.setOnClickListener { onLivroClickAberto(livroempA) }
    }

    override fun getItemCount(): Int = listaLivrosEmpAbertoUser.size

}