package com.example.githubusers.screens.repos

import com.example.githubusers.base.BasePresenter
import com.example.githubusers.data.UserRepository
import com.example.githubusers.network.Repos
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UserListReposPresenter(private val repoRepository: UserRepository, private var login: String): BasePresenter<UserListReposView>() {


    fun loadRepos() {
        view?.showLoading(true)
        compositeDisposable.add(repoRepository.loadUserListRepos(login)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onLoadUserReposSuccess, ::onLoadUserReposError))
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