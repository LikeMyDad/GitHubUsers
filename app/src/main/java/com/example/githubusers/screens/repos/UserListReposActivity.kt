package com.example.githubusers.screens.repos

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.App
import com.example.githubusers.R
import com.example.githubusers.base.BaseActivity
import com.example.githubusers.network.Repos
import com.example.githubusers.screens.repos.di.DaggerReposComponent
import com.example.githubusers.screens.repos.di.ReposModule
import kotlinx.android.synthetic.main.activity_main.recyclerView
import javax.inject.Inject

class UserListReposActivity : BaseActivity(R.layout.activity_user_list_repos), UserListReposView {

    private companion object{
        const val LOGIN_EXTRA = "login"
    }

    private lateinit var linearLayoutManager: LinearLayoutManager

    private val component by lazy {
        DaggerReposComponent.builder()
            .appComponent((application as App).appComponent)
            .reposModule(ReposModule())
            .build()
    }

    @Inject
    lateinit var presenter: UserListReposPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        component.inject(this)

        presenter.onAttach(this)
        presenter.loadRepos(
            intent.getStringExtra(LOGIN_EXTRA).toString()
        )
    }

    override fun onLoadUserListRepos(repos: List<Repos>) {
        recyclerView.adapter = UserListReposRecyclerAdapter(repos)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }
}