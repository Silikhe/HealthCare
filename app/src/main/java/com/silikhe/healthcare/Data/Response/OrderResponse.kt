package com.silikhe.healthcare.Data.Response

data class OrderResponse(
    val date_created: String,
    val item_description: String,
    val item_name: String,
    val item_quantity: String,
    val updated_at: String
)