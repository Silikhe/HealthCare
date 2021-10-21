package com.silikhe.healthcare.Data.Repository

import com.silikhe.healthcare.Data.Network.AuthApi
import com.silikhe.healthcare.Data.Network.OrderApi
import com.silikhe.healthcare.Data.UserPreferences

class OrderRepos (
    private val api: OrderApi

) : BaseRepos(){

    suspend fun getOrders() = safeApiCall {
        api.getOrders()
    }

}
