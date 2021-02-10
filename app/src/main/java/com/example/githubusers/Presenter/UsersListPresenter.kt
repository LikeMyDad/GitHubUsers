package com.example.githubusers.Presenter

import android.content.Intent
import android.view.View
import com.example.githubusers.Activities.MainActivity
import com.example.githubusers.Activities.UserListRepos
import com.example.githubusers.Adapters.RecyclerAdapterListUsers
import com.example.githubusers.Adapters.RecyclerAdapterUserListRepos
import com.example.githubusers.Model.Model
import com.example.githubusers.Post_Get_Requests.User
import com.example.githubusers.UserContract

class UsersListPresenter(private var activity: MainActivity): UserContract.UserPresenter{

    private lateinit var model: Model
    private lateinit var intent: Intent

    init {
        activity.initView()
    }

    override fun loadUsersList() =
        RecyclerAdapterListUsers(model.callBackUserList(), ::onItemClick)

    private fun onItemClick(login: String) {
        intent = Intent(activity, UserListRepos::class.java)
        intent.putExtra("login", login)
        activity.startActivity(intent)
    }
}