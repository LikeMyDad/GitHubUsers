package com.example.githubusers.screens.main

import com.example.githubusers.Model.Model
import com.example.githubusers.base.BasePresenter
import com.example.githubusers.network.User

class UsersListPresenter(private val model: Model) : BasePresenter<MainView>() {

    fun loadUsers() {
        view?.showLoading(true)
        model.loadlUserList(::onUserLoadingSuccess, ::onUserLoadingError)
    }

    private fun onUserLoadingSuccess(users: List<User>){
        view?.showLoading(false)
        view?.onUsersLoaded(users)
    }

    private fun onUserLoadingError(throwable: Throwable){
        view?.showLoading(false)
        view?.showError(throwable)
    }

}