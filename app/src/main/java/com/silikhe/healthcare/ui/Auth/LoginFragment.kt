package com.silikhe.healthcare.ui.Auth

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.silikhe.healthcare.Data.Network.AuthApi
import com.silikhe.healthcare.Data.Network.Resource
import com.silikhe.healthcare.Data.Repository.AuthRepos
import com.silikhe.healthcare.R
import com.silikhe.healthcare.databinding.LoginFragmentBinding
import com.silikhe.healthcare.ui.Base.BaseFragment
import com.silikhe.healthcare.ui.Hospital.HomeActivity
import com.silikhe.healthcare.ui.enable
import com.silikhe.healthcare.ui.startNewActivity
import com.silikhe.healthcare.ui.visible

class LoginFragment : BaseFragment<AuthViewModel, LoginFragmentBinding, AuthRepos>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.pbLoading.visible(false)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {

                    val sharedPref =
                        activity?.getSharedPreferences("shared_pref", Context.MODE_PRIVATE) ?: return@Observer
                    with(sharedPref.edit()) {
                        putString("auth_key", it.value.access)
                        apply()
                    }



//                    Toast.makeText(context, "" + it.value.access, Toast.LENGTH_SHORT).show()
                    viewModel.saveAuthToken(it.value.access)

                    requireActivity().startNewActivity(HomeActivity::class.java)

                    PreferenceManager.getDefaultSharedPreferences(activity).edit()
                        .putString("Auth_token", it.value.access).apply()
//                    val mimi = PreferenceManager.getDefaultSharedPreferences(activity)
//                        .getString("Auth_token", it.value.access)
//                    Toast.makeText(context, "" + mimi, Toast.LENGTH_SHORT).show()
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

//        binding.etEmail.addTextChangedListener {
//            val email: String = binding.etEmail.text.toString().trim()
//            binding.btnLogin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
//        }


        binding.btnLogin.setOnClickListener {

            binding.pbLoading.visible(true)
            binding.btnLogin.enable(false)

            val email: String = binding.etEmail.text.toString().trim()
            val password = binding.etPass.text.toString()
            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

            //validation
            if (email.isEmpty() || email.isBlank() || password.isBlank()) {
                Toast.makeText(
                    requireContext(),
                    "Email address or password cannot be blank",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (!email.matches(emailPattern.toRegex())) {
                Toast.makeText(requireContext(), "Enter valid email address", Toast.LENGTH_LONG)
                    .show()
            }
            if (password.length < 6) {
                Toast.makeText(
                    requireContext(),
                    "Password must be more than 6 characters",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                viewModel.login(email, password)
            }
        }


    }

    override fun getViewModel() = AuthViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginFragmentBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() =
        AuthRepos(remoteDataSource.buidApi(AuthApi::class.java), userPreferences)
}