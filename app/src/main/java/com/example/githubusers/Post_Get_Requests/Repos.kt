package com.example.githubusers.Post_Get_Requests

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