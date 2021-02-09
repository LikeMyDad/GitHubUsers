package com.example.githubusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.items_leaner_layout.view.*
import kotlin.reflect.KFunction1


class RecyclerAdapterListUsers(
    private val list: MutableList<User>,
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
                user.id?.let { onItemClick(it) }
            }
            item_number.text = user.id
            content.text = user.login
        }
    }

}