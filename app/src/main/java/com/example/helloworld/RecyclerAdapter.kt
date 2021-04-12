package com.example.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val text = arrayOf("Кнопка номер 2",
        "Кнопка номер 3", "Кнопка номер 4", "Кнопка номер 5",
        "Кнопка номер 6", "Кнопка номер 7", "Кнопка номер 8",
        "Кнопка номер 9")

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemText.text = text[i]
    }

    override fun getItemCount(): Int {
        return text.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemText: Button = itemView.findViewById(R.id.cardButton)
    }
}