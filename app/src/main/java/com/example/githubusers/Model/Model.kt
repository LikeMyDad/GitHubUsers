package com.example.githubusers.Model

import android.content.Context
import android.view.View
import android.widget.Toast
import com.example.githubusers.Adapters.RecyclerAdapterListUsers
import com.example.githubusers.Post_Get_Requests.GithubApi
import com.example.githubusers.NetworkService
import com.example.githubusers.Post_Get_Requests.User
import com.example.githubusers.UserContract
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Model: UserContract.UserModel {
    private val service = NetworkService()
        .createService(GithubApi::class.java)

    private lateinit var listUsers: MutableList<User>

    override fun callBackUserList(context: Context): MutableList<User> {
        val call: Call<MutableList<User>> = service.usersList()

        call.enqueue(object : Callback<MutableList<User>> {
            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>
            ) {
                if (response.isSuccessful) {
                    listUsers = response.body()!!
                }
            }
            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT)
            }
        })
        return listUsers
    }

    override fun callBackUserReposList() {
        TODO("Not yet implemented")
    }

}