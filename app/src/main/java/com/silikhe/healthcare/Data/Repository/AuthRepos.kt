package com.silikhe.healthcare.Data.Repository

import com.silikhe.healthcare.Data.Network.AuthApi

class AuthRepos (
    private val api: AuthApi

) : BaseRepos(){

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }


    suspend fun signup(
        username: String,
        email: String,
        password: String,
        type: String
    ) = safeApiCall {
        api.signup(username, email, password, type)
    }
}
