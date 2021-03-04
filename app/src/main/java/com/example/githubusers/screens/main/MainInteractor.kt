/*package com.example.githubusers.screens.main

import android.text.BoringLayout
import com.example.githubusers.base.BaseInteractor
import com.example.githubusers.data.UserRepository
import com.example.githubusers.network.User
import com.example.githubusers.utils.Workers
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver


class MainInteractor(private val userRepository: UserRepository): BaseInteractor(workers) {

    fun sinceLoadUsers(since: Int, onSuccess: (user: List<User>) -> Unit, onError: (Throwable) -> Unit) {
        compositeDisposable.add(userRepository.sinceLoadUsersList(since)
            .schedule()
            .subscribe(onSuccess, onError))
    }

    fun loadUsers(onSuccess: (user: List<User>) -> Unit, onError: (Throwable) -> Unit) {
        compositeDisposable.add(userRepository.loadUsersList()
            .schedule()
            .subscribe(onSuccess, onError))
    }



}

*/