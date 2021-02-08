package com.example.githubusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val values = mutableListOf<DummyContent.DummyItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_leaner_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return values.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.viewId.text = item.id
        holder.viewContent.text = item.content
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val viewId: TextView = view.findViewById(R.id.item_number)
        val viewContent: TextView = view.findViewById(R.id.content)
    }
}