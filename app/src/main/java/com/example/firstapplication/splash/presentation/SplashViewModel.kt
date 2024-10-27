package com.example.firstapplication.splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.firstapplication.splash.domain.entity.UserListResponse
import com.example.firstapplication.splash.domain.use_case.UserUseCase
import com.example.firstapplication.utils.packeges.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val userlistUseCase: UserUseCase): BaseViewModel() {

    private val _userlistResponse: MutableLiveData<ArrayList<UserListResponse>> = MutableLiveData()
    val userlistResponse: LiveData<ArrayList<UserListResponse>> = _userlistResponse

    fun getUsers() = userlistUseCase(UserUseCase.Params(""), viewModelScope) {
            it.fold(
                ::handleFailure,
                ::handleResponse
            )
        }

    private fun handleResponse(userlistResponse: ArrayList<UserListResponse>) {
        _userlistResponse.value = userlistResponse
    }

}