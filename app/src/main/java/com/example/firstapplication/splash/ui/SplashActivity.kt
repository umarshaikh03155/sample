package com.example.firstapplication.splash.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.firstapplication.R
import com.example.firstapplication.splash.domain.entity.UserListResponse
import com.example.firstapplication.splash.presentation.SplashViewModel
import com.example.firstapplication.utils.extensions.failure
import com.example.firstapplication.utils.extensions.observe
import com.example.firstapplication.utils.platform.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    private val splashViewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        with(splashViewModel){
            observe(userlistResponse,::onSplashResponse)
            failure(failure, ::handleFailure)
        }

        getUsers()
    }


    private fun getUsers() {
        splashViewModel.getUsers()
    }


    private fun onSplashResponse(userlistResponse: ArrayList<UserListResponse>?) {
        if (!userlistResponse.isNullOrEmpty())
            for (i in userlistResponse)
                Log.i("checkdatamine",""+i.name+" "+i.email)
        else
            showToast(this,"nothing found..")

    }
}