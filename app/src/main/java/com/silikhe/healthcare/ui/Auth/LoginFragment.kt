package com.silikhe.healthcare.ui.Auth

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.silikhe.healthcare.Data.Network.AuthApi
import com.silikhe.healthcare.Data.Network.Resource
import com.silikhe.healthcare.Data.Repository.AuthRepos
import com.silikhe.healthcare.Data.UserPreferences
import com.silikhe.healthcare.R
import com.silikhe.healthcare.databinding.LoginFragmentBinding
import com.silikhe.healthcare.ui.Base.BaseFragment
import com.silikhe.healthcare.ui.Home.HomeActivity
import kotlinx.coroutines.launch
import java.util.prefs.Preferences

class LoginFragment : BaseFragment<AuthViewModel, LoginFragmentBinding, AuthRepos>() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    lifecycleScope.launch {
                        userPreferences.saveAuthToken(it.value.access)
                    }

//                    PreferenceManager.getDefaultSharedPreferences(activity).edit().putString("Auth_token", it.value.access).apply()
//                    PreferenceManager.getDefaultSharedPreferences(activity).getString("Auth_token", it.value.access)

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

//        binding.btnLogin.setOnClickListener {
//            val email = binding.etEmail.text.toString().trim()
//            val password = binding.etPass.text.toString().trim()
//
//            viewModel.login(email, password)
//            Toast.makeText(requireContext(), email + " "+ password, Toast.LENGTH_SHORT).show()
//        }

        binding.btnLogin.setOnClickListener {

            val email: String = binding.etEmail.text.toString().trim()
            val password = binding.etPass.text.toString()
//            val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

            //validation
            if (email.isEmpty() || email.isBlank() || password.isBlank()){
                Toast.makeText(requireContext(), "Email address or password cannot be blank", Toast.LENGTH_LONG).show()
            }
//            if (!email.matches(emailPattern.toRegex())){
//                Toast.makeText(requireContext(), "Enter valid email address", Toast.LENGTH_LONG).show()
//            }
            if (password.length < 6){
                Toast.makeText(requireContext(), "Password must be more than 6 characters", Toast.LENGTH_LONG).show()
            }
            else {
//                val email = binding.etEmail.text.toString().trim()
//                val password = binding.etPass.text.toString().trim()
                viewModel.login(email, password)

//                Toast.makeText(requireContext(), email + " "+ password, Toast.LENGTH_SHORT).show()

            }
        }


    }

    override fun getViewModel() = AuthViewModel::class.java


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginFragmentBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepos(remoteDataSource.buidApi(AuthApi::class.java))
}