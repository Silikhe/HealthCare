package com.silikhe.healthcare.Data.Network

import com.silikhe.healthcare.Data.Response.SignupResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {
//since we are using fields we need to ke the post as ->

    @FormUrlEncoded
    //endpoint to hit
    @POST("auth/login/")
    suspend fun login(
        @Field("Email") email: String,
        @Field("Password") password: String,

        ): LoginResponse


    @FormUrlEncoded
    //endpoint to hit
    @POST("auth/register/")
    suspend fun signup(
        @Field("Username") username: String,
        @Field("Email") email: String,
        @Field("Password") password: String,
        @Field("type") type: String,
        ): SignupResponse
}