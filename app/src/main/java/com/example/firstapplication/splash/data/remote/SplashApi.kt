package com.example.firstapplication.splash.data.remote

import com.example.firstapplication.splash.domain.entity.UserListResponse
import retrofit2.Call
import retrofit2.http.*

internal interface SplashApi {

    companion object {
        private const val USERLIST = "public/v2/users"
    }


    @GET(USERLIST)
    fun getUserList(): Call<ArrayList<UserListResponse>>

}
