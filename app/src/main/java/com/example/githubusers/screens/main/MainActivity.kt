package com.example.githubusers.screens.main

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    private lateinit var adapter: MainRecyclerAdapter

    private val listUsers = mutableListOf<User>()
    private var NUM_OF_USERS = 30

    private companion object {
        private const val SCROLL_DIRECTION = 1
        private const val since = 1
    }

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

        adapter = MainRecyclerAdapter(listUsers, ::onItemClick)
        adapter.hasLoading = presenter.hasLoading
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                if (!recyclerView.canScrollVertically(SCROLL_DIRECTION) &&
                    newState == RecyclerView.SCROLL_STATE_IDLE && adapter.hasLoading
                ) {
                    presenter.onNextPage(since + NUM_OF_USERS)
                }
            }
        })
    }

    override fun onUsersLoaded(users: List<User>) {
        listUsers.addAll(users)
        adapter.notifyDataSetChanged()
    }

    private fun onItemClick(login: String) {
        intent = Intent(this, UserListReposActivity::class.java)
            .apply { putExtra("login", login) }
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}
