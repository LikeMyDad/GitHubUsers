package com.example.githubusers.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.network.User
import com.example.githubusers.screens.main.ui.BaseViewHolder
import com.example.githubusers.screens.main.ui.LoadingViewHolder
import com.example.githubusers.screens.main.ui.UserViewHolder
import java.lang.Exception

class MainRecyclerAdapter(
    private val list: List<User>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<BaseViewHolder>() {

    private companion object {
        const val TYPE_CONTENT = 0
        const val TYPE_LOADING = 1
    }

    var hasLoading = true

    override fun getItemViewType(position: Int): Int {
        return if(isLoadingPosition(position)) TYPE_LOADING else TYPE_CONTENT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context)
        return when(viewType) {
            TYPE_CONTENT -> UserViewHolder(view.inflate(R.layout.items_leaner_layout, parent, false))
            TYPE_LOADING -> LoadingViewHolder(view.inflate(R.layout.item_loading, parent, false))
            else -> throw(Exception())
        }
    }

    override fun getItemCount(): Int = if(list.isEmpty()) 0 else getSize()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (!isLoadingPosition(position)) {
            holder.bind(list[position])
            holder.itemView.setOnClickListener { onItemClick(list[position].login!!) }
        }
    }

    private fun getSize() = if(hasLoading) list.size + 1 else list.size

    private fun isLoadingPosition(position: Int) = position == list.size

}