package com.example.firstapplication.utils.platform

import android.Manifest
import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.firstapplication.R
import com.example.firstapplication.utils.exception.Failure
import java.util.*
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    fun showToast(context:Context,message:String){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }


     fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> {
                showToast(this,"NetworkError")
            }
            is Failure.ServerError -> {
                showToast(this,"ServerError")
            }
            else -> {
                showToast(this,"GeneralError")
            }
        }
    }

}
