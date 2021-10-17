package com.silikhe.healthcare.Network

import com.silikhe.healthcare.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataSourceControl {
    companion object{
        private const val BASE_URL = "http://fw-supplies.herokuapp.com/"
    }

    fun <Api> buidApi(
        api: Class<Api>
    ): Api{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
//            .client(OkHttpClient.Builder().also { client ->
//                if (BuildConfig.DEBUG){
//                    val logging = HttpLoggingInterceptor()
//                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
//                    client.addInterceptor(logging)
//                }
//            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}