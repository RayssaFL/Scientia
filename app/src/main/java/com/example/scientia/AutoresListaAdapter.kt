package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AutoresListaAdapter(
    private val listaAutores: List<Autores>,
    private val onClick: (Autores) -> Unit
) : RecyclerView.Adapter<AutoresListaAdapter.AutoresViewHolder>() {

    inner class AutoresViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar: TextView = view.findViewById(R.id.avatarAutores)
        val nome: TextView = view.findViewById(R.id.nomeAutoresItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoresViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_autores_lista, parent, false)
        return AutoresViewHolder(view)
    }

    override fun onBindViewHolder(holder: AutoresViewHolder, position: Int) {
        val autores = listaAutores[position]
        holder.avatar.text = autores.nome.firstOrNull()?.toString()?.uppercase() ?: "?"
        holder.nome.text = autores.nome

        holder.itemView.setOnClickListener {
            onClick(autores)
        }
    }

    override fun getItemCount(): Int = listaAutores.size
}
