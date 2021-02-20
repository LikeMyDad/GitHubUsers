package com.example.githubusers.network


import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface GithubApi {

    @GET("/users")
    fun  usersList():
            Observable<List<User>>

    @GET("/users/{user}/repos")
    fun reposList(@Path("user") login: String):
            Observable<List<Repos>>

}