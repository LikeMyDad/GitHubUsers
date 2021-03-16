package com.example.githubusers.base

interface BaseView{

    fun showLoading(isLoading: Boolean)

    fun showError(throwable: Throwable)

}