package com.example.githubusers.base

import com.example.githubusers.screens.main.RecyclerAdapterListUsers
import com.example.githubusers.screens.repos.RecyclerAdapterUserListRepos
import com.example.githubusers.network.Repos
import com.example.githubusers.network.User

interface BaseModel {

        fun loadUserList(onSuccess: (List<User>) -> Unit, onError: (Throwable) -> Unit)

        fun loadUserListRepos(login: String, onSuccess: (List<Repos>) -> Unit, onError: (Throwable) -> Unit)

}