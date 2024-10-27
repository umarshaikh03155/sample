package com.example.firstapplication.splash.domain.entity

import com.google.gson.annotations.SerializedName

data class UserListResponse(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("gender")
    val gender: String? = null,

    @field:SerializedName("status")
    val status: String? = null,



)
