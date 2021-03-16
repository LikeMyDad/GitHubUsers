package com.example.githubusers.network

interface ServiceProvider{
    fun <T>createService(service: Class<T>): T
}