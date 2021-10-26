package com.silikhe.healthcare.ui.Hospital

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.silikhe.healthcare.Data.Network.AuthApi
import com.silikhe.healthcare.Data.Network.OrderApi
import com.silikhe.healthcare.Data.Network.Resource
import com.silikhe.healthcare.Data.Repository.AuthRepos
import com.silikhe.healthcare.Data.Repository.OrderRepos
import com.silikhe.healthcare.Data.Response.OrderResponse
import com.silikhe.healthcare.R
import com.silikhe.healthcare.databinding.FragmentHomeBinding
import com.silikhe.healthcare.ui.Base.BaseFragment
import com.silikhe.healthcare.ui.visible

class HomeFragment :
//    Fragment(){
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
    BaseFragment<HomeViewModel, FragmentHomeBinding, OrderRepos>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.pbLoading.visible(true)

        viewModel.getOrder()

        viewModel.order.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.pbLoading.visible(false)

//                    updateUi(it.value)
                }
//                is Resource.Failure -> {
//                    binding.pbLoading.visible(false)
//                    Toast.makeText(context, "Fail", Toast.LENGTH_SHORT).show()
//                }
            }
        })
    }

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)


    override fun getFragmentRepository(): OrderRepos {
        val token = "QMUzlOLk69F9wDdXeC5hYUBsMZElbfEMjcHUfOfSt6aHNpxQqoh5Iut0seYdePPR"


        val api = remoteDataSource.buidApi(OrderApi::class.java, token)
        return OrderRepos(api)
    }


    fun updateUi(order: OrderResponse) {
//        with(binding) {
//            textViewId.text = order.item_name
            Toast.makeText(context, order.date_created, Toast.LENGTH_SHORT).show()
//        }
    }

}