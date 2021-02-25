package com.example.githubusers.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.App
import com.example.githubusers.R
import com.example.githubusers.base.BaseActivity
import com.example.githubusers.network.User
import com.example.githubusers.screens.main.di.DaggerMainComponent
import com.example.githubusers.screens.main.di.MainModule
import com.example.githubusers.screens.repos.UserListReposActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(R.layout.activity_main), MainView {

    private lateinit var linearLayoutManager: LinearLayoutManager

    private val component by lazy {
        DaggerMainComponent.builder()
            .appComponent((application as App).appComponent)
            .mainModule(MainModule())
            .build()
    }

    @Inject
    lateinit var presenter: UsersListPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        component.inject(this)
        presenter.onAttach(this)
        presenter.loadUsers()
    }

    override fun onUsersLoaded(users: List<User>) {
        recyclerView.adapter = RecyclerAdapterListUsers(users, ::onItemClick)
    }

    private fun onItemClick(login: String) {
        intent = Intent(this, UserListReposActivity::class.java)
        intent.putExtra("login", login)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}
