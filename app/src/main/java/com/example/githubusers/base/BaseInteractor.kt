/*package com.example.githubusers.base

import com.example.githubusers.utils.Workers
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable

abstract class BaseInteractor(private val workers: Workers) {

    protected val compositeDisposable = CompositeDisposable()

    open fun clear() {
        compositeDisposable.clear()
    }

    fun <T> Single<T>.schedule() = apply {
        observeOn(workers.observe)
        subscribeOn(workers.subscribe)
    }

    fun <T> Observable<T>.schedule() = apply {
        observeOn(workers.observe)
        subscribeOn(workers.subscribe)
    }
}*/