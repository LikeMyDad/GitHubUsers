package com.example.githubusers.screens.repos.di

import com.example.githubusers.dagger.ActivityScope
import com.example.githubusers.data.UserRepository
import com.example.githubusers.data.UserRepositoryImpl
import com.example.githubusers.network.GithubApi
import com.example.githubusers.screens.repos.UserListReposPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class ReposModule() {

    @Provides
    @ActivityScope
    fun provideListReposPresenter(repository: UserRepository) =  UserListReposPresenterImpl(repository)

    @Provides
    @ActivityScope
    fun provideUserRepository(api: GithubApi): UserRepository = UserRepositoryImpl(api)

}