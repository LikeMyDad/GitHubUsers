package com.example.githubusers.screens.main

import com.example.githubusers.base.BasePresenter
import com.example.githubusers.data.UserRepository
import com.example.githubusers.network.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class UsersListPresenterImpl(private val userRepository: UserRepository) : BasePresenter<MainView>() {

    fun loadUsers() {
        view?.showLoading(true)
        compositeDisposable.add(userRepository.loadUsersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoadingSuccess, ::onUserLoadingError))
    }

    private fun onUserLoadingSuccess(users: List<User>) {
        view?.showLoading(false)
        view?.onUsersLoaded(users)
    }

    private fun onUserLoadingError(throwable: Throwable) {
        view?.showLoading(false)
        view?.showError(throwable)
    }

}