package com.example.githubusers

import android.app.Application
import com.example.githubusers.dagger.AppComponent
import com.example.githubusers.dagger.AppModule
import com.example.githubusers.dagger.DaggerAppComponent

class App : Application(){

    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        initDaggerAppComponent()
    }

    private fun initDaggerAppComponent(){
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}