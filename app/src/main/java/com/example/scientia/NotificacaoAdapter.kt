package com.example.scientia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class NotificacaoAdapter(
    private var listaNotificacoes: List<Notificacao>,
) : RecyclerView.Adapter<NotificacaoAdapter.NotificacaoViewHolder>() {

    inner class NotificacaoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fotoNoti: ImageView = view.findViewById(R.id.imgNotificacao)
        val tituloAviso: TextView = view.findViewById(R.id.TituloAviso)
        val descAviso: TextView = view.findViewById(R.id.DescAviso)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificacaoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_notificacao, parent, false)
        return NotificacaoViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotificacaoViewHolder, position: Int) {
        val noti = listaNotificacoes[position]
        holder.fotoNoti.setImageResource(noti.notificacaoImg)
        holder.tituloAviso.text = noti.titulo
        holder.descAviso.text = noti.descricao
    }

    override fun getItemCount(): Int = listaNotificacoes.size
}
