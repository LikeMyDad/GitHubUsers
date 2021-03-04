package com.example.githubusers.dagger

import android.content.Context
import com.example.githubusers.App
import com.example.githubusers.network.GithubApi
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(application: App)

    fun provideGitHubApi(): GithubApi

    fun provideApplicationContext(): Context

//    fun provideWorkers(): Workers
}