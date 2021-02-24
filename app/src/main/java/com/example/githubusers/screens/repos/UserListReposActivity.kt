package com.example.githubusers.screens.repos

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.R
import com.example.githubusers.base.BaseActivity
import com.example.githubusers.data.UserRepository
import com.example.githubusers.data.UserRepositoryImpl
import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.NetworkServiceProvider
import com.example.githubusers.network.Repos
import kotlinx.android.synthetic.main.activity_main.recyclerView

class UserListReposActivity : BaseActivity(R.layout.activity_user_list_repos), UserListReposView {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var presenter: UserListReposPresenter
    private val repository: UserRepository = UserRepositoryImpl(
        NetworkServiceProvider()
            .createService(GithubApi::class.java)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        presenter = UserListReposPresenter(repository, intent.getStringExtra("login")!!)
        presenter.onAttach(this)
        presenter.loadRepos()
    }

    override fun onLoadUserListRepos(repos: List<Repos>) {
        recyclerView.adapter = RecyclerAdapterUserListRepos(repos)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}