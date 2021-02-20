package com.example.githubusers.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.network.User
import kotlinx.android.synthetic.main.items_leaner_layout.view.*


class RecyclerAdapterListUsers(
    private val list: List<User>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<RecyclerAdapterListUsers.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_leaner_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(user: User) = with(itemView) {
            setOnClickListener {
                user.login?.let { onItemClick(it) }
            }
            item_number.text = (list.indexOf(user) + 1).toString()
            content.text = user.login
        }
    }

}