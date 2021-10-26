package com.silikhe.healthcare.ui.Base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.silikhe.healthcare.Data.Repository.AuthRepos
import com.silikhe.healthcare.Data.Repository.BaseRepos
import com.silikhe.healthcare.ui.Auth.AuthViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory (
    private val repository: BaseRepos
    ) : ViewModelProvider.NewInstanceFactory(){

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return when {
                modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepos) as T
                else -> throw IllegalArgumentException("ViewModelClass Not Found")
            }
        }
}