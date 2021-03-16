package com.example.githubusers.screens.main

import com.example.githubusers.base.BasePresenter
import com.example.githubusers.data.UserRepository.UserRepository
import com.example.githubusers.network.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersListPresenterImpl(private val repository: UserRepository) : BasePresenter<MainView>() {

    private companion object {
        const val NUM_USERS = 30
        var id = 1
    }

    fun loadUsers() {
        view?.showLoading(true)
        compositeDisposable.add(repository.loadUsersList(id) // load once and we get list users with since 1 to 30 ID's
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoadingSuccess, ::onUserLoadingError))
    }

    fun onNextPage() {
        id += NUM_USERS
        compositeDisposable.add(repository.loadUsersList(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoadingNextPageSuccess, ::onUserLoadingError))
    }

    private fun onUserLoadingSuccess(users: List<User>) {
        view?.showLoading(false)
        view?.onUsersLoaded(users)
    }

    private fun onUserLoadingNextPageSuccess(users: List<User>) {
        view?.onAdditionalUsersLoaded(users)
        view?.setListLoading(false)
    }

    private fun onUserLoadingError(throwable: Throwable) {
        view?.showLoading(false)
        view?.showError(throwable)
    }




}