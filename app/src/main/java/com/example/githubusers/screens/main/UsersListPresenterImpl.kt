package com.example.githubusers.screens.main

import com.example.githubusers.base.BasePresenter
import com.example.githubusers.data.UserRepository
import com.example.githubusers.network.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersListPresenterImpl(private val repository: UserRepository) : BasePresenter<MainView>() {

    private val dataUserList = mutableListOf<User>()
    var hasLoading = true

    fun loadUsers() {
        view?.showLoading(true)
        compositeDisposable.add(repository.loadUsersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoadingSuccess, ::onUserLoadingError))
    }

    fun onNextPage(since: Int) {
        compositeDisposable.add(repository.sinceLoadUsersList(since)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoadingNextPageSuccess, ::onUserLoadingNextPageError))
    }

    private fun onUserLoadingSuccess(users: List<User>) {
        view?.showLoading(false)
        dataUserList.addAll(users)
        view?.onUsersLoaded(dataUserList)
    }

    private fun onUserLoadingError(throwable: Throwable) {
        view?.showLoading(false)
        view?.showError(throwable)
    }

    private fun onUserLoadingNextPageSuccess(users: List<User>) {
        hasLoading = users.size >= 30
        dataUserList.addAll(users)
        view?.onUsersLoaded(dataUserList)
    }

    private fun onUserLoadingNextPageError(throwable: Throwable) {
        view?.showError(throwable)
    }



}