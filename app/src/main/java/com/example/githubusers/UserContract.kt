package com.example.githubusers

import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.Adapters.RecyclerAdapterListUsers
import com.example.githubusers.Adapters.RecyclerAdapterUserListRepos
import com.example.githubusers.Post_Get_Requests.Repos
import com.example.githubusers.Post_Get_Requests.User

interface UserContract {

    interface ActivityView {
        fun initView()
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
        fun callBackUserList(): MutableList<User>
        fun callBackUserReposList(login: String): MutableList<Repos>
    }
}