package com.example.githubusers.screens.repos.di

import com.example.githubusers.dagger.ActivityScope
import com.example.githubusers.dagger.AppComponent
import com.example.githubusers.screens.repos.UserListReposActivity
import dagger.Component

@Component(modules = [ReposModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface ReposComponent {

    fun inject(activity: UserListReposActivity)

}