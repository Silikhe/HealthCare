package com.silikhe.healthcare.ui.Base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.silikhe.healthcare.Data.Network.DataSourceControl
import com.silikhe.healthcare.Data.Repository.BaseRepos

abstract class BaseFragment<VM: ViewModel, B:ViewBinding, R: BaseRepos> : Fragment() {
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    protected val remoteDataSource = DataSourceControl()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModel())

        return binding.root
    }

    abstract fun getViewModel() : Class<VM>

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) : B

    abstract fun getFragmentRepository(): R

}