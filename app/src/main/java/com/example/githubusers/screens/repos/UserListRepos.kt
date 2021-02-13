package com.example.githubusers.screens.repos

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.model.Model
import com.example.githubusers.R
import com.example.githubusers.base.BaseActivity
import com.example.githubusers.network.Repos
import kotlinx.android.synthetic.main.activity_main.recyclerView

class UserListRepos : BaseActivity(R.layout.activity_user_list_repos), UserListReposView {

    private lateinit var linearLayoutManager: LinearLayoutManager


    private val model = Model()
    private val presenter = intent.getStringExtra("login")?.let {
        UserListReposPresenter(model, it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        presenter!!.onAttach(this)
        presenter.loadRepos()
    }

    override fun onLoadUserListRepos(repos: List<Repos>) {
        recyclerView.adapter = RecyclerAdapterUserListRepos(repos)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDetach()
    }
}