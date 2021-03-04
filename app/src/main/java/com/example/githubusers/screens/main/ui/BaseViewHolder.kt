package com.example.githubusers.screens.main.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.network.User

abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view) {

    open fun bind(item: User) {}

}