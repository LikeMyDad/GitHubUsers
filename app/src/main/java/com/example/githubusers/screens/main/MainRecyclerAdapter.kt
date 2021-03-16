package com.example.githubusers.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.network.User
import com.example.githubusers.screens.main.ui.BaseViewHolder
import com.example.githubusers.screens.main.ui.LoadingViewHolder
import com.example.githubusers.screens.main.ui.UserViewHolder
import kotlin.properties.Delegates

class MainRecyclerAdapter(
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<BaseViewHolder>() {

    private companion object {
        const val TYPE_CONTENT = 0
        const val TYPE_LOADING = 1
    }

    private var userList = mutableListOf<User>()
    var loadingState = true

    override fun getItemViewType(position: Int): Int {
        return if (isLoadingPosition(position)) TYPE_LOADING else TYPE_CONTENT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_CONTENT -> UserViewHolder(
                view.inflate(
                    R.layout.items_leaner_layout,
                    parent,
                    false
                )
            )
            TYPE_LOADING -> LoadingViewHolder(view.inflate(R.layout.item_loading, parent, false))
            else -> throw(Exception())
        }
    }

    override fun getItemCount(): Int = if (userList.isEmpty()) 0 else getSize()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (!isLoadingPosition(position)) {
            holder.bind(userList[position])
            holder.itemView.setOnClickListener {
                onItemClick(userList[position].login!!)
            }
        }
    }

    fun setLoading(isLoading: Boolean) {
        loadingState = isLoading
        val loadingPos = userList.size + 1
        if (loadingState) notifyItemInserted(loadingPos) else notifyItemRemoved(loadingPos)
    }

    fun setUsers(list: List<User>) {
        userList.addAll(list)
        notifyDataSetChanged()
    }

    fun addNewUsersSet(list: List<User>) {
        val oldListSize = userList.size
        userList.addAll(list)
        notifyItemRangeChanged(oldListSize, getSize())
    }

    private fun getSize() = if (loadingState) userList.size + 1 else userList.size

    private fun isLoadingPosition(position: Int) = position == userList.size
}