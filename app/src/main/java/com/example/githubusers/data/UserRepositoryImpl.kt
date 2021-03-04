package com.example.githubusers.data

import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.Repos
import com.example.githubusers.network.User
import io.reactivex.Single

class UserRepositoryImpl(private val service: GithubApi) : UserRepository {

    override fun loadUsersList(): Single<List<User>> {
        return service.usersList(1)
    }

    override fun sinceLoadUsersList(since: Int): Single<List<User>> {
        return service.usersList(since)
    }

    override fun loadUserListRepos(login: String): Single<List<Repos>> {
        return service.reposList(login)
    }
}