package com.silikhe.healthcare.Data.Repository

import com.silikhe.healthcare.Data.Network.AuthApi
import com.silikhe.healthcare.Data.UserPreferences

class UserRepos (
    private val api: AuthApi,
    private val preferences: UserPreferences

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

    suspend fun saveAuthToken(token: String){
        preferences.saveAuthToken(token)
    }
}
