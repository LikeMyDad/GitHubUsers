package com.example.githubusers.screens.main.di

import com.example.githubusers.dagger.ActivityScope
import com.example.githubusers.data.UserRepository.UserRepository
import com.example.githubusers.data.UserRepository.UserRepositoryImpl
import com.example.githubusers.network.GithubApi
import com.example.githubusers.screens.main.UsersListPresenterImpl
import dagger.Module
import dagger.Provides


@Module
class MainModule(){

    @Provides
    @ActivityScope
    fun provideUsersListPresenter(repository: UserRepository)= UsersListPresenterImpl(repository)

    @Provides
    @ActivityScope
    fun provideUserRepository(api: GithubApi): UserRepository =
        UserRepositoryImpl(api)
}