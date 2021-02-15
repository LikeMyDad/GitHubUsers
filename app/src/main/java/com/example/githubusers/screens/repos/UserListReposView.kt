package com.example.githubusers.screens.repos

import com.example.githubusers.base.BaseView
import com.example.githubusers.network.Repos

interface UserListReposView: BaseView {

    fun onLoadUserListRepos(repos: List<Repos>)

}