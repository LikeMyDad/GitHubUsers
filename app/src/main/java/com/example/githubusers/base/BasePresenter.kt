package com.example.githubusers.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T: BaseView>{

    protected var view: T? = null
    protected val compositeDisposable = CompositeDisposable()

    open fun onAttach(view: T){
        this.view = view
    }

    open fun onDetach(){
        view = null
        compositeDisposable.dispose()
    }
}