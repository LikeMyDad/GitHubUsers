package com.example.githubusers

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Repos {
    @SerializedName("name")
    @Expose
    val nameRepos: String? = null
    @SerializedName("id")
    @Expose
    val idRepos: String? = null
}