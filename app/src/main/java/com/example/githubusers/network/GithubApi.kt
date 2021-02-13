package com.example.githubusers.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {
    @GET("/users")
    fun usersList():
            Call<List<User>>

    @GET("/users/{user}/repos")
    fun reposList(@Path("user") login: String):
            Call<List<Repos>>
}