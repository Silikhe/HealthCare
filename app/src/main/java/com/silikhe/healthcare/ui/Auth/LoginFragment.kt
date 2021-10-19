package com.silikhe.healthcare.ui.Auth

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.silikhe.healthcare.Data.Network.AuthApi
import com.silikhe.healthcare.Data.Network.Resource
import com.silikhe.healthcare.Data.Repository.AuthRepos
import com.silikhe.healthcare.databinding.LoginFragmentBinding
import com.silikhe.healthcare.ui.Base.BaseFragment
import com.silikhe.healthcare.ui.Home.HomeActivity
import java.util.prefs.Preferences

class LoginFragment : BaseFragment<AuthViewModel, LoginFragmentBinding, AuthRepos>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    Toast.makeText(
                        requireContext(),
                        "Login successful token " + it.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                    //save the token the start new activity

                    PreferenceManager.getDefaultSharedPreferences(activity).edit().putString("Auth_token", it.toString()).apply()
                    PreferenceManager.getDefaultSharedPreferences(activity).getString("Auth_token", it.toString())
//                    requireActivity().startNewActivity(HomeActivity::class.java)
                    Intent(requireContext(), HomeActivity::class.java)

                }
                is Resource.Failure -> {
                    if (it.isNetworkError)
                        Toast.makeText(
                            requireContext(),
                            "Check your internet connection",
                            Toast.LENGTH_SHORT
                        ).show()
                    else
                        Toast.makeText(requireContext(), "Login Fail", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPass.text.toString().trim()

            viewModel.login(email, password)

        }

    }

    override fun getViewModel() = AuthViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginFragmentBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepos(remoteDataSource.buidApi(AuthApi::class.java))
}