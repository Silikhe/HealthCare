package com.silikhe.healthcare.Data.Network

import com.silikhe.healthcare.Data.Response.OrderResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface OrderApi {
    @FormUrlEncoded
    //endpoint to hit
    @POST("order/")
    suspend fun createOrder(
        @Field("item_name") item_name: String,
        @Field("item_description") item_description: String,
        @Field("item_quantity") item_quantity: String
    ): OrderResponse

//    @GET("order/id")
//    suspend fun createOrder(
//        @Field("item_name") item_name: String,
//        @Field("item_description") item_description: String,
//        @Field("item_quantity") item_quantity: String
//    ): OrderResponse

//    @PUT("/order/id")
//    suspend fun createOrder(
//        @Field("item_name") item_name: String,
//        @Field("item_description") item_description: String,
//        @Field("item_quantity") item_quantity: String
//    ): OrderResponse
//
//    @PATCH("/order/id")
//    suspend fun createOrder(
//        @Field("item_name") item_name: String,
//        @Field("item_description") item_description: String,
//        @Field("item_quantity") item_quantity: String
//    ): OrderResponse

    //    @DELETE("/order/id")
//    suspend fun createOrder(
//        @Field("item_name") item_name: String,
//        @Field("item_description") item_description: String,
//        @Field("item_quantity") item_quantity: String
//    ): OrderResponse
}