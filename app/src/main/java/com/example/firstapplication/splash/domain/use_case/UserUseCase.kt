package com.example.firstapplication.splash.domain.use_case

import com.croem.daim.core.interactor.UseCase
import com.example.firstapplication.splash.domain.entity.UserListResponse
import com.example.firstapplication.splash.domain.repository.SplashRepository
import javax.inject.Inject

class UserUseCase @Inject constructor(private val splashRepository: SplashRepository): UseCase<ArrayList<UserListResponse>, UserUseCase.Params>() {

    override suspend fun run(params: Params) = splashRepository.getusers()

    data class Params(var nothing:String)

}