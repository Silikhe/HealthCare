package com.silikhe.healthcare.Data.Response

data class SignupResponse(
    val access: String,
    val refresh: String,
    val status: Int,
    val success_message: String
)