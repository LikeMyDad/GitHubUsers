package com.example.githubusers.Model

import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.NetworkService
import com.example.githubusers.network.Repos
import com.example.githubusers.network.User
import com.example.githubusers.UserContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Model : UserContract.UserModel {
    private val service = NetworkService()
        .createService(GithubApi::class.java)

    override fun loadlUserList(
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

    override fun callBackUserReposList(
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