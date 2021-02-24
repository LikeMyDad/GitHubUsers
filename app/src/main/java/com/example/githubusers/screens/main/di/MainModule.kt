package com.example.githubusers.screens.main.di

import com.example.githubusers.dagger.ActivityScope
import com.example.githubusers.data.UserRepository
import com.example.githubusers.data.UserRepositoryImpl
import com.example.githubusers.network.GithubApi
import com.example.githubusers.screens.main.UsersListPresenterImpl
import dagger.Module
import dagger.Provides


@Module
class MainModule{

    @Provides
    @ActivityScope
    fun provideUsersListPresenter(userRepository: UserRepository)= UsersListPresenterImpl(userRepository)

    @Provides
    @ActivityScope
    fun provideUserRepository(api: GithubApi): UserRepository = UserRepositoryImpl(api)
}