package com.example.githubusers.Presenter

import com.example.githubusers.Activities.UserListRepos
import com.example.githubusers.Adapters.RecyclerAdapterUserListRepos
import com.example.githubusers.Model.Model
import com.example.githubusers.UserContract

class UserReposListPresenter(activity: UserListRepos): UserContract.UserReposPresenter {

    private lateinit var model: Model
    private val login = activity.intent.getStringExtra("login")

    init {
        activity.initView()
    }

    override fun loadUserReposList() =
        RecyclerAdapterUserListRepos(model.callBackUserReposList(login!!))
}