package com.silikhe.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.silikhe.healthcare.Data.UserPreferences
import com.silikhe.healthcare.ui.Auth.AuthActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        finish()

        val userPreferences = UserPreferences(this)
//        userPreferences.authToken.asLiveData().observe(this, Observer {
//            Toast.makeText(this, it ?: "Token is null", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AuthActivity::class.java))
//        })
    }

}