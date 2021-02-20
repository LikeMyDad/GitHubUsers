package com.example.githubusers.network


import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    @GET("/users")
    fun  usersList():
            Single<List<User>>

    @GET("/users/{user}/repos")
    fun reposList(@Path("user") login: String):
            Single<List<Repos>>

}