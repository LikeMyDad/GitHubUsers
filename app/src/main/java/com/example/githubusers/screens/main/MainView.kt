package com.example.githubusers.screens.main

import com.example.githubusers.base.BaseView
import com.example.githubusers.network.User

interface MainView: BaseView {

    fun onUsersLoaded(users: List<User>)
}