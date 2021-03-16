package com.example.githubusers.data.UserListRepoRepository

import com.example.githubusers.network.Repos
import io.reactivex.Single

interface UserListRepoRepository {

    fun loadUserListRepos(login: String): Single<List<Repos>>

}