package com.example.githubusers.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.Adapters.RecyclerAdapterListUsers
import com.example.githubusers.Presenter.UserReposListPresenter
import com.example.githubusers.Presenter.UsersListPresenter
import com.example.githubusers.R
import com.example.githubusers.UserContract
import kotlinx.android.synthetic.main.activity_main.*

class UserListRepos : AppCompatActivity(), UserContract.ReposView {

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var userReposListPresenter: UserReposListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list_repos)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        userReposListPresenter = UserReposListPresenter(this)
    }

    override fun initView() {
        recyclerView.adapter = userReposListPresenter.loadUserReposList()
    }


/*    private fun getUserRepos() {



        val call: Call<MutableList<Repos>> = service.reposList(intent.getStringExtra("login")!!)

        progress_bar.visibility = View.VISIBLE

        call.enqueue(object: Callback<MutableList<Repos>>{
            override fun onResponse(call: Call<MutableList<Repos>>, response: Response<MutableList<Repos>>) {
                if(response.isSuccessful) {
                    listAdapterUserListRepos =
                        RecyclerAdapterUserListRepos(
                            response.body()!!
                        )
                    recyclerView.adapter = listAdapterUserListRepos
                    progress_bar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<MutableList<Repos>>, t: Throwable) {
                Toast.makeText(this@UserListRepos, "${t.message}", Toast.LENGTH_SHORT)
                progress_bar.visibility = View.GONE
            }

        })

    } */
}