package com.example.githubusers.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.Post_Get_Requests.Repos
import kotlinx.android.synthetic.main.items_leaner_layout.view.*

class RecyclerAdapterUserListRepos(private val list: MutableList<Repos>): RecyclerView.Adapter<RecyclerAdapterUserListRepos.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_leaner_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(repos: Repos) = with(itemView) {
            item_number.text = repos.idRepos
            content.text = repos.nameRepos
        }
    }
}