package com.example.githubusers.Post_Get_Requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {
    @SerializedName("id")
    @Expose
    val id: String? = null
    @SerializedName("login")
    @Expose
    val login: String? = null
}