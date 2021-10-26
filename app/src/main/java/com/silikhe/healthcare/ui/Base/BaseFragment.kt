package com.silikhe.healthcare.ui.Base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.silikhe.healthcare.Data.Network.DataSourceControl
import com.silikhe.healthcare.Data.Repository.BaseRepos
import com.silikhe.healthcare.Data.Response.OrderResponse
import com.silikhe.healthcare.Data.UserPreferences

abstract class BaseFragment<VM : ViewModel, B : ViewBinding, R : BaseRepos> : Fragment() {
    protected lateinit var userPreferences: UserPreferences

    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    protected val remoteDataSource = DataSourceControl()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       //Initialize userprefernces
        userPreferences = UserPreferences(requireContext())

        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())

        return binding.root
    }

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    abstract fun getFragmentRepository(): R


}