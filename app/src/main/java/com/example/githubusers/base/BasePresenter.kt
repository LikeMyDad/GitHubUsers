package com.example.githubusers.base

open class BasePresenter<T: BaseView>{

    protected var view: T? = null

    open fun onAttach(view: T){
        this.view = view
    }

    open fun onDetach(){
        view = null
    }
}