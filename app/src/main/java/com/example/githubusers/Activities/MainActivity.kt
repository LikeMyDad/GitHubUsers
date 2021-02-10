package com.example.githubusers.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubusers.Adapters.RecyclerAdapterListUsers
import com.example.githubusers.NetworkService
import com.example.githubusers.Presenter.Presenter
import com.example.githubusers.R
import com.example.githubusers.Post_Get_Requests.GithubApi
import com.example.githubusers.Post_Get_Requests.User
import com.example.githubusers.UserContract
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), UserContract.ActivityView {

    private lateinit var presenter: Presenter

    private lateinit var listAdapterListUsers: RecyclerAdapterListUsers
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var service: GithubApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        service = NetworkService().createService(GithubApi::class.java)

        getListUsers()
    }

    private fun getListUsers() {
        val call: Call<MutableList<User>> = service.usersList()

        progress_bar.visibility = View.VISIBLE

        call.enqueue(object : Callback<MutableList<User>> {

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                if (response.isSuccessful) {
                    listAdapterListUsers =
                        RecyclerAdapterListUsers(
                            response.body()!!,
                            ::onItemClick
                        )
                    recyclerView.adapter = listAdapterListUsers
                    progress_bar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT)
                progress_bar.visibility = View.GONE
            }
        })

    }

    private fun onItemClick(userLogin: String) {
        val intent = Intent(this, UserListRepos::class.java)
        intent.putExtra("login", userLogin)
        startActivity(intent)
    }

    override fun showUsersList() {
        TODO("Not yet implemented")
    }

    override fun showUserReposList() {
        TODO("Not yet implemented")
    }


}