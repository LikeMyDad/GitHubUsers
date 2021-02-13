package com.example.githubusers

import com.example.githubusers.screens.main.RecyclerAdapterListUsers
import com.example.githubusers.screens.repos.RecyclerAdapterUserListRepos
import com.example.githubusers.network.Repos
import com.example.githubusers.network.User

interface UserContract {

    interface ActivityView {
        fun initView()
        fun onItemClick(login: String)
    }

    interface ReposView {
        fun initView()
    }

    interface UserPresenter {
        fun loadUsersList(): RecyclerAdapterListUsers

    }

    interface UserReposPresenter {
        fun loadUserReposList(): RecyclerAdapterUserListRepos
    }

    interface UserModel {
        fun loadlUserList(onSuccess: (List<User>) -> Unit, onError: (Throwable) -> Unit)
        fun callBackUserReposList(login: String, onSuccess: (List<Repos>) -> Unit, onError: (Throwable) -> Unit)
    }
}