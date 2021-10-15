    package com.silikhe.healthcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.silikhe.healthcare.AuthFragments.RegisterTabFragment
import com.silikhe.healthcare.databinding.ActivityOnbordBinding

    class MainActivity : AppCompatActivity() {
lateinit var binding: ActivityOnbordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnbordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragBtn1.setOnClickListener{
            replaceFragment(LoginFragment())
        }


        binding.fragBtn2.setOnClickListener{
            replaceFragment(SignupFragment())
        }
    }

        private fun replaceFragment(fragment: Fragment){
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frag_container, fragment)
            fragmentTransaction.commit()
        }
}