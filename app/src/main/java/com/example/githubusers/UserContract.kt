package com.example.githubusers

interface UserContract {

    interface ActivityView {
        fun showUsersList()
        fun showUserReposList()
    }

    interface UserPresenter {
        fun loadUsersList()
        fun loadUserReposList()
    }

    interface UserModel {
        fun callBackUserList()
        fun callBackUserReposList()
    }
}