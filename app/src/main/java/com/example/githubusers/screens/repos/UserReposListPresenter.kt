package com.example.githubusers.screens.repos

import com.example.githubusers.Model.Model
import com.example.githubusers.UserContract

class UserReposListPresenter(private var activity: UserListRepos): UserContract.UserReposPresenter {

    private lateinit var model: Model
    private val login = activity.intent.getStringExtra("login")

    init {
        activity.initView()
    }

    override fun loadUserReposList() =
        RecyclerAdapterUserListRepos(
            model.callBackUserReposList(
                login!!
            )
        )
}