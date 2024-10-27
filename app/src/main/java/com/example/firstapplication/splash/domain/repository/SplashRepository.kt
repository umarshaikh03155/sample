package com.example.firstapplication.splash.domain.repository

import com.example.firstapplication.splash.data.remote.SplashService
import com.example.firstapplication.splash.domain.entity.UserListResponse
import com.example.firstapplication.utils.exception.Failure
import com.example.firstapplication.utils.functional.Either
import com.example.firstapplication.utils.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface SplashRepository {


    fun getusers(): Either<Failure, ArrayList<UserListResponse>>


   class Network @Inject constructor(private val networkHandler: NetworkHandler, private val service: SplashService) : SplashRepository {


       override fun getusers(): Either<Failure, ArrayList<UserListResponse>> {
           return when (networkHandler.isNetworkAvailable()) {
               true -> request(service.getUserList(), { it }, ArrayList<UserListResponse>())

               false -> Either.Left(Failure.NetworkConnection)
           }
       }


       private fun <T, RList> request(call: Call<T>, transform: (T) -> RList, default: T): Either<Failure, RList> {
           return try {
               val response = call.execute()
               when (response.isSuccessful) {
                   true -> Either.Right(transform((response.body() ?: default)))
                   false -> Either.Left(Failure.ServerError)
               }
           } catch (exception: Throwable) {
               Either.Left(Failure.ServerError)
           }
       }

   }

}