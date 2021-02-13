package com.example.githubusers.screens.repos

import com.example.githubusers.model.Model
import com.example.githubusers.base.BasePresenter
import com.example.githubusers.network.Repos

class UserListReposPresenter(private var model: Model, private var login: String): BasePresenter<UserListReposView>() {

    fun loadRepos() {
        view?.showLoading(true)
        model.loadUserListRepos(login, ::onLoadUserReposSuccess, ::onLoadUserReposError)
    }

    private fun onLoadUserReposSuccess(repos: List<Repos>) {
        view?.showLoading(false)
        view?.onLoadUserListRepos(repos)
    }

    private fun onLoadUserReposError(throwable: Throwable) {
        view?.showLoading(false)
        view?.showError(throwable)
    }
}