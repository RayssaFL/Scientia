package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LivroEmpAdmAdapter(
    private val listaLivrosEmp: List<LivroEmp> ,
    private val onLivroClick: (LivroEmp) -> Unit) :
    RecyclerView.Adapter<LivroEmpAdmAdapter.LivroEmpViewHolder>() {

    inner class LivroEmpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagemCapa: ImageView = itemView.findViewById(R.id.imgCapaLivroEmp)
        val titulo: TextView = itemView.findViewById(R.id.tvTituloLivroEmp)
        val autor: TextView = itemView.findViewById(R.id.tvAutorLivroEmp)
        val cardItem: View = itemView.findViewById(R.id.cardItemEmp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LivroEmpViewHolder{
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_livro_emp, parent, false)
        return LivroEmpViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroEmpViewHolder, position: Int) {
        val livroemp = listaLivrosEmp[position]
        holder.imagemCapa.setImageResource(livroemp.capaResId)
        holder.titulo.text = livroemp.titulo
        holder.autor.text = livroemp.autor
        holder.cardItem.setOnClickListener { onLivroClick(livroemp) }
    }

    override fun getItemCount(): Int = listaLivrosEmp.size

}