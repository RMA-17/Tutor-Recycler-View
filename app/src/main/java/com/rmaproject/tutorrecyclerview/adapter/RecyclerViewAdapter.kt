package com.rmaproject.tutorrecyclerview.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.card.MaterialCardView
import com.rmaproject.tutorrecyclerview.MainActivity
import com.rmaproject.tutorrecyclerview.R
import com.rmaproject.tutorrecyclerview.adapter.RecyclerViewAdapter.RecyclerViewViewHolder
import com.rmaproject.tutorrecyclerview.dataclass.Makanan

class RecyclerViewAdapter(private val listMakanan: ArrayList<Makanan>) : Adapter<RecyclerViewViewHolder>() {

    var listener:((Makanan) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
            .let { view -> RecyclerViewViewHolder(view) }
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        val makanan = listMakanan[position]
        holder.bindView(makanan)
        val cardView = holder.itemView.findViewById<MaterialCardView>(R.id.clickableCardView)
        cardView.setOnClickListener {
            listener?.invoke(makanan)
        }
    }

    override fun getItemCount() = listMakanan.size

    class RecyclerViewViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        fun bindView(makanan: Makanan) {
            itemView.findViewById<TextView>(R.id.txt_makanan)
                .text = makanan.namaMakanan
        }
    }
}