package com.silikhe.healthcare.Network

import android.provider.ContactsContract
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
//since we are using fields we need to ke the post as ->

    @FormUrlEncoded
    //endpoint to hit
    @POST("auth/login")
    suspend fun login(
        @Field("Email") email: String,
        @Field("Password") password: String,

        ): LoginResponse
}