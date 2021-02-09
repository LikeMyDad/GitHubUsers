package com.example.githubusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_leaner_layout.view.*

class RecyclerAdapterUserListRepos(private val list: MutableList<Repos>): RecyclerView.Adapter<RecyclerAdapterUserListRepos.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterUserListRepos.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_leaner_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerAdapterUserListRepos.ViewHolder, position: Int) {
        val item = list[position]
        holder.viewContent.text = item.nameRepos
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val viewContent: TextView = itemView.content
    }
}