package com.example.githubusers.data.UserListRepoRepository

import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.Repos
import io.reactivex.Single

class UserListRepoRepositoryImpl(private val service: GithubApi): UserListRepoRepository {

    override fun loadUserListRepos(login: String): Single<List<Repos>> {
        return service.reposList(login)
    }
}