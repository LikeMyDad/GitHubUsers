package com.example.githubusers.screens.main.di

import com.example.githubusers.dagger.ActivityScope
import com.example.githubusers.dagger.AppComponent
import com.example.githubusers.screens.main.MainActivity
import dagger.Component


@Component(modules = [MainModule::class], dependencies = [AppComponent::class])
@ActivityScope
interface MainComponent {

    fun inject(activity: MainActivity)

}