package com.silikhe.healthcare.ui.Auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silikhe.healthcare.Data.Network.LoginResponse
import com.silikhe.healthcare.Data.Network.Resource
import com.silikhe.healthcare.Data.Repository.AuthRepos
import com.silikhe.healthcare.Data.Response.SignupResponse
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepos
): ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    private val _signupResponse : MutableLiveData<Resource<SignupResponse>> = MutableLiveData()
    val signupResponse: LiveData<Resource<SignupResponse>>
        get() = _signupResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = repository.login(email, password)
    }

    fun signup (
        email: String,
        username: String,
        password: String,
    type: String
    ) = viewModelScope.launch {
        _signupResponse.value = repository.signup(email, username, password, type)
    }
}