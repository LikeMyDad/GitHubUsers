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

    private companion object {
        const val SCROLL_DIRECTION = 1
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

        adapter = MainRecyclerAdapter(::onItemClick)
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(SCROLL_DIRECTION) &&
                    newState == RecyclerView.SCROLL_STATE_IDLE
                ) {
                    adapter.setLoading(true)
                    recyclerView.scrollToPosition(adapter.itemCount)
                    presenter.onNextPage()
                }
            }
        })
    }

    override fun setListLoading(isLoading: Boolean) {
        adapter.setLoading(isLoading)
    }

    override fun onUsersLoaded(users: List<User>) {
        adapter.setUsers(users)
    }

    override fun onAdditionalUsersLoaded(users: List<User>) {
        adapter.addNewUsersSet(users)
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
