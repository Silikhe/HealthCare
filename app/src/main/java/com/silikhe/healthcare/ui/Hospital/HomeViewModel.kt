package com.silikhe.healthcare.ui.Hospital

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silikhe.healthcare.Data.Network.Resource
import com.silikhe.healthcare.Data.Repository.OrderRepos
import com.silikhe.healthcare.Data.Response.OrderResponse
import kotlinx.coroutines.launch

class HomeViewModel (private val repository : OrderRepos): ViewModel(){

    private val _order: MutableLiveData<Resource<OrderResponse>> = MutableLiveData()
    val order: LiveData<Resource<OrderResponse>>
    get() = _order

    fun getOrder() = viewModelScope.launch {
        _order.value = repository.getOrders()
    }
}