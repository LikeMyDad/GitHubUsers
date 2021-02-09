package com.example.githubusers

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {
    @GET("/users")
    fun usersList():
            Call<MutableList<User>>

    @GET("/users/{user}/repos")
    fun reposList(@Path("login") login: String):
            Call<MutableList<Repos>>
}