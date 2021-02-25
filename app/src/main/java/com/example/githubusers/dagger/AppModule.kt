package com.example.githubusers.dagger

import android.content.Context
import com.example.githubusers.network.GithubApi
import com.example.githubusers.network.NetworkServiceProvider
import com.example.githubusers.network.ServiceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val applicationContext: Context) {

    @Provides
    @Singleton
    fun provideGitHubApi(serviceProvider: ServiceProvider) = serviceProvider.createService(GithubApi::class.java)

    @Provides
    @Singleton
    fun provideServiceProvider(): ServiceProvider = NetworkServiceProvider()

    @Provides
    @Singleton
    fun provideApplicationContext()  = applicationContext
}