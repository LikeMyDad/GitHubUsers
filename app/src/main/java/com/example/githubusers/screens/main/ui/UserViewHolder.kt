package com.example.githubusers.screens.main.ui

import android.view.View
import com.example.githubusers.network.User
import kotlinx.android.synthetic.main.items_leaner_layout.view.*

class UserViewHolder(
    view: View
//    private val onItemClick: (String) -> Unit
): BaseViewHolder(view) {

    override fun bind(user: User) = with(itemView) {
/*        setOnClickListener {
            user.login?.let { onItemClick(it) }
        } */
        content.text = user.login
    }
}