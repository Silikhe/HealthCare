package com.silikhe.healthcare.Data.Network

import com.silikhe.healthcare.Data.Response.OrderResponse
import com.silikhe.healthcare.Data.Response.SignupResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
//since we are using fields we need to ke the post as ->

    @FormUrlEncoded
    //endpoint to hit
    @POST("auth/login/")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,

        ): LoginResponse


    @FormUrlEncoded
    //endpoint to hit
    @POST("auth/register/")
    suspend fun signup(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("type") type: String,
        ): SignupResponse

    @FormUrlEncoded
    //endpoint to hit
    @GET("orders/")
    suspend fun signup(
        @Field("item_name") item_name: String,
        @Field("item_quantity") item_quantity: String,
        @Field("item_description") item_description : String,
    ): OrderResponse
}