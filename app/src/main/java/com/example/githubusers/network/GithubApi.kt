package com.example.githubusers.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {

    @GET("/users")
    fun  usersList(@Query("since") since: Int):
            Single<List<User>>

    @GET("/users/{user}/repos")
    fun reposList(@Path("user") login: String):
            Single<List<Repos>>

}