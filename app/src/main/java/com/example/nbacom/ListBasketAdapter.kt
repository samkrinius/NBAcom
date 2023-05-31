package com.example.nbacom

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListBasketAdapter (private val listBasket: ArrayList<Basket>): RecyclerView.Adapter<ListBasketAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoGame: ImageView = itemView.findViewById(R.id.nba_photo)
        val textVtitle: TextView = itemView.findViewById(R.id.textV_game_title)
        val textVdesc: TextView = itemView.findViewById(R.id.textV_game_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.basket_item_row,parent,false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, developer, publisher, releaseDate, tags, similar, gameLogo) = listBasket[position]
        holder.logoGame.setImageResource(gameLogo)
        holder.textVtitle.text = title
        holder.textVdesc.text = description

        holder.itemView.setOnClickListener{
            val intentDetail = Intent(holder.itemView.context, detailActivity::class.java)
            intentDetail.putExtra("key_game", listBasket[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)

        }
    }

    override fun getItemCount(): Int = listBasket.size
}