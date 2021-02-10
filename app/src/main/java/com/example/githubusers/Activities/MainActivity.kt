package com.example.githubusers.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.Adapters.RecyclerAdapterListUsers
import com.example.githubusers.Presenter.UsersListPresenter
import com.example.githubusers.R
import com.example.githubusers.UserContract
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), UserContract.ActivityView {

    private lateinit var usersListPresenter: UsersListPresenter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        usersListPresenter = UsersListPresenter(this)
    }
    override fun initView() {
        recyclerView.adapter = usersListPresenter.loadUsersList()
    }

 /*   private fun getListUsers() {
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

    } */

/*    private fun onItemClick(userLogin: String) {
        val intent = Intent(this, UserListRepos::class.java)
        intent.putExtra("login", userLogin)
        startActivity(intent)
    } */

}