package com.silikhe.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.silikhe.healthcare.ui.Auth.AuthActivity
import com.silikhe.healthcare.ui.Hospital.HomeActivity
import com.silikhe.healthcare.ui.startNewActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activity =  HomeActivity::class.java


//        val userPreferences = UserPreferences(this)
//        userPreferences.authToken.asLiveData().observe(this, Observer {
//        val activity = if(it == null) AuthActivity::class.java else HomeActivity::class.java
        startNewActivity(activity)
        Toast.makeText(this, "dk", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this, it ?: "Token is null", Toast.LENGTH_SHORT).show()
//        })

        finish()

        startActivity(Intent(this, AuthActivity::class.java))
    }

}