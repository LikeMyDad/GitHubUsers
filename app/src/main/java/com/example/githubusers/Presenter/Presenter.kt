package com.example.githubusers.Presenter

import com.example.githubusers.Activities.MainActivity
import com.example.githubusers.Model.Model
import com.example.githubusers.UserContract

class Presenter: UserContract.UserPresenter{
    private lateinit var model: Model
    private lateinit var mainActivity: MainActivity

    override fun loadUsersList() {
        TODO("Not yet implemented")
    }

    override fun loadUserReposList() {
        TODO("Not yet implemented")
    }
}