package com.example.githubusers.data

import com.example.githubusers.network.Repos
import com.example.githubusers.network.User
import io.reactivex.Single

interface UserRepository {

    fun loadUsersList(): Single<List<User>>

    fun loadUserListRepos(login: String): Single<List<Repos>>

}