package com.example.githubusers.data.UserRepository

import com.example.githubusers.network.Repos
import com.example.githubusers.network.User
import io.reactivex.Single

interface UserRepository {

    fun loadUsersList(since: Int): Single<List<User>>
}