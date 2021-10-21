package com.silikhe.healthcare.ui.Auth


import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.silikhe.healthcare.Data.Network.Resource
import com.silikhe.healthcare.Data.Repository.AuthRepos
import com.silikhe.healthcare.R
import com.silikhe.healthcare.databinding.RegisterFragmentBinding
import com.silikhe.healthcare.ui.Base.BaseFragment
import androidx.lifecycle.Observer
import com.silikhe.healthcare.Data.Network.AuthApi

class SignupFragment :  BaseFragment<AuthViewModel, RegisterFragmentBinding, AuthRepos>() {
    var type = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        val switch_sw :Switch = binding.swSwitch;
        binding.swSwitch.setOnClickListener {
            if (switch_sw.isChecked){
                type = "DONOR"
            }
            else{
                type = "HOSPITAL"
            }
        }

        viewModel.signupResponse.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Resource.Success -> {
                    Toast.makeText(requireContext(), "login successful", Toast.LENGTH_LONG).show()

                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
                is Resource.Failure -> {
                    if (it.isNetworkError)
                        Toast.makeText(requireContext(), "Check your internet connection", Toast.LENGTH_SHORT).show()
                    else
                        Toast.makeText(requireContext(), "ERROR", Toast.LENGTH_LONG).show()
                }
            }
        })

        binding.btnSign.setOnClickListener {
            val username: String = binding.etEmail.text.toString().trim()
            val email: String = binding.etPass.text.toString().trim()
            val password: String = binding.etPassword.text.toString()


            if (username.isEmpty() || email.isBlank()) {
                Toast.makeText(requireContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
            if (!email.contains("@"))
                Toast.makeText(requireContext(), "invalid email address", Toast.LENGTH_SHORT).show()
            if (password.length < 6)
                Toast.makeText(requireContext(), "password length must be > 6", Toast.LENGTH_SHORT).show()
            else
                viewModel.signup(username, email, password, type )

        }

        binding.btnToSignup.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }



    override fun getViewModel() = AuthViewModel::class.java




    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): RegisterFragmentBinding = RegisterFragmentBinding.inflate(inflater, container, false)

    override fun getFragmentRepository() = AuthRepos(remoteDataSource.buidApi(AuthApi::class.java), userPreferences)



}