package com.example.githubusers.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.Adapters.RecyclerAdapterUserListRepos
import com.example.githubusers.NetworkService
import com.example.githubusers.R
import com.example.githubusers.Post_Get_Requests.GithubApi
import com.example.githubusers.Post_Get_Requests.Repos
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListRepos : AppCompatActivity() {

    private lateinit var listAdapterUserListRepos: RecyclerAdapterUserListRepos
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var service: GithubApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list_repos)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        /*
        * Создание сервиса ретрофит
        * Задаем в параметре класс с get запросом к серверу
         */
        service = NetworkService().createService(GithubApi::class.java)

        getUserRepos()
    }

    private fun getUserRepos() {



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

    }
}