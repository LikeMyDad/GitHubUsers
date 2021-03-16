package com.example.githubusers.data.UserRepository

import com.example.githubusers.data.UserRepository.UserRepository
import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.Repos
import com.example.githubusers.network.User
import io.reactivex.Single

class UserRepositoryImpl(private val service: GithubApi): UserRepository {

    override fun loadUsersList(since: Int): Single<List<User>> {
        return service.usersList(since)
    }
}