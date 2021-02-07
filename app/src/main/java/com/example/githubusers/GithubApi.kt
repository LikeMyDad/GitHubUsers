package com.example.githubusers

import retrofit2.Call
import retrofit2.http.GET


interface GithubApi {
    @GET("/users")
    fun usersList(): Call<List<User>>
}