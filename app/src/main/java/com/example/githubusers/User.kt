package com.example.githubusers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("id")
    @Expose
    val id: String? = null
    @SerializedName("login")
    @Expose
    val login: String? = null
    @SerializedName("repos_url")
    @Expose
    val repos_url: String? = null
}