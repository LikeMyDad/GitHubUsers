package com.example.githubusers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_leaner_layout.view.*


class RecyclerAdapter(private val context: Context, private val list: MutableList<User>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_leaner_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.viewId.text = item.id
        holder.viewContent.text = item.login
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val viewId: TextView = itemView.item_number
        val viewContent: TextView = itemView.content
    }
}