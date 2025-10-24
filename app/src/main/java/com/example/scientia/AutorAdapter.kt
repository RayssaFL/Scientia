package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.scientia.UsuarioListaAdapter.UsuarioViewHolder

class AutorAdapter(
    private var listaAutores: List<Autor>,
    private val onClick: (Autor) -> Unit
) : RecyclerView.Adapter<AutorAdapter.AutorViewHolder>() {

    inner class AutorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val avatar: TextView = view.findViewById(R.id.avatarAutores)
        val nome: TextView = view.findViewById(R.id.nomeAutoresItem)
        val card: CardView = view.findViewById(R.id.cardAutor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_autores_lista, parent, false)
        return AutorViewHolder(view)
    }

    override fun onBindViewHolder(holder: AutorViewHolder, position: Int) {
        val autor = listaAutores[position]
        holder.avatar.text = autor.nome.firstOrNull()?.toString()?.uppercase() ?: "?"
        holder.nome.text = autor.nome
        holder.card.setOnClickListener { onClick(autor) }
    }

    override fun getItemCount(): Int = listaAutores.size


}
