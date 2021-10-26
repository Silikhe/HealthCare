package com.silikhe.healthcare

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.silikhe.healthcare.Data.UserPreferences
import com.silikhe.healthcare.ui.Auth.AuthActivity
import com.silikhe.healthcare.ui.Hospital.HomeActivity
import com.silikhe.healthcare.ui.startNewActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activity =  HomeActivity::class.java


        val userPreferences = UserPreferences(this)
        val sharedPreferences: SharedPreferences =
            applicationContext.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        val savedString: String? = sharedPreferences.getString("auth_key", null)

//        userPreferences.authToken.asLiveData().observe(this, Observer {
         if(savedString == null) AuthActivity::class.java else HomeActivity::class.java
        startNewActivity(activity)
        Toast.makeText(this, "dk$savedString", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this, it ?: "Token is null", Toast.LENGTH_SHORT).show()
//        })

        finish()

        startActivity(Intent(this, AuthActivity::class.java))
    }

}