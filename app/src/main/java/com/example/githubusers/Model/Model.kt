package com.example.githubusers.Model

import com.example.githubusers.Post_Get_Requests.GithubApi
import com.example.githubusers.NetworkService
import com.example.githubusers.Post_Get_Requests.Repos
import com.example.githubusers.Post_Get_Requests.User
import com.example.githubusers.UserContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Model: UserContract.UserModel {
    private val service = NetworkService()
        .createService(GithubApi::class.java)

    private lateinit var listUsers: MutableList<User>
    private lateinit var userReposList: MutableList<Repos>

    override fun callBackUserList(): MutableList<User> {
        val call: Call<MutableList<User>> = service.usersList()

        call.enqueue(object : Callback<MutableList<User>> {

            override fun onResponse(
                call: Call<MutableList<User>>,
                response: Response<MutableList<User>>) {
                if (response.isSuccessful) listUsers = response.body()!!
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
//                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT)
            }

        })
        return listUsers
    }

    override fun callBackUserReposList(login: String): MutableList<Repos> {
        val call: Call<MutableList<Repos>> = service.reposList(login)

        call.enqueue(object : Callback<MutableList<Repos>> {
            override fun onResponse(
                call: Call<MutableList<Repos>>,
                response: Response<MutableList<Repos>>
            ) {
                if (response.isSuccessful) userReposList = response.body()!!
            }

            override fun onFailure(call: Call<MutableList<Repos>>, t: Throwable) {
//                Toast.makeText(this@UserListRepos, "${t.message}", Toast.LENGTH_SHORT)
            }
        })
        return userReposList
    }
}