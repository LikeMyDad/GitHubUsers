package com.example.githubusers.screens.main

import com.example.githubusers.base.BasePresenter
import com.example.githubusers.data.UserRepository
import com.example.githubusers.network.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import kotlin.math.sin

class UsersListPresenterImpl(private val repository: UserRepository) : BasePresenter<MainView>() {

    private val dataUserList = mutableListOf<User>()

    fun loadUsers() {
        view?.showLoading(true)
        compositeDisposable.add(repository.loadUsersList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoadingSuccess, ::onUserLoadingError))
    }

    fun onNextPage(since: Int) {
        view?.showLoading(true)
        compositeDisposable.add(repository.sinceLoadUsersList(since)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onUserLoadingSuccess, ::onUserLoadingError))
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


//   fun loadUsers() {
//        view?.showLoading(true)
//        interactor.loadUsers(::onUserLoadingSuccess, ::onUserLoadingError)
//    }
//
//    fun onNextPage(since: Int) {
//        view?.showLoading(true)
//        interactor.sinceLoadUsers(since, ::onUserLoadingSuccess, ::onUserLoadingError)
//    }
//
//    private fun onUserLoadingSuccess(users: List<User>) {
//        view?.showLoading(false)
//        view?.onUsersLoaded(users)
//
//    }
//
//    private fun onUserLoadingError(throwable: Throwable) {
//        view?.showLoading(false)
//        view?.showError(throwable)
//    }
}