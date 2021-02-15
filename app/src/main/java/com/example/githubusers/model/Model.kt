package com.example.githubusers.model

import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.NetworkService
import com.example.githubusers.network.Repos
import com.example.githubusers.network.User
import com.example.githubusers.base.BaseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Model : BaseModel {

    private val service = NetworkService()
        .createService(GithubApi::class.java)

    override fun loadUserList(
        onSuccess: (List<User>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call: Call<List<User>> = service.usersList()

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    onError(Exception(response.message()))
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                onError(t)
            }

        })
    }

    override fun loadUserListRepos(
        login: String,
        onSuccess: (List<Repos>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call: Call<List<Repos>> = service.reposList(login)

        call.enqueue(object : Callback<List<Repos>> {
            override fun onResponse(
                call: Call<List<Repos>>,
                response: Response<List<Repos>>
            ) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    onError(Exception(response.message()))
                }
            }

            override fun onFailure(call: Call<List<Repos>>, t: Throwable) {
                onError(t)
            }
        })
    }

}