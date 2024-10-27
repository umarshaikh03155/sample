package com.example.firstapplication.splash.data.remote

import retrofit2.Retrofit
import javax.inject.Inject

class SplashService @Inject constructor(retrofit: Retrofit): SplashApi {
    private val splashApi by lazy { retrofit.create(SplashApi::class.java) }

    override fun getUserList() = splashApi.getUserList()


}