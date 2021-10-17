package com.silikhe.healthcare.Repository

import com.silikhe.healthcare.Network.AuthApi

class AuthRepos (
    private val api: AuthApi

) : BaseRepos(){

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }
}
