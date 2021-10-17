package com.silikhe.healthcare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import com.silikhe.healthcare.AuthFragments.RegisterTabFragment

class MainActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            val intent = Intent(this, SignupFragment::class.java)
            overridePendingTransition(0, 0);
            finish();
            startActivity(intent);
//            startActivity(Intent(this, SignupFragment::class.java))

            // close this activity
//            finish()
        }, SPLASH_TIME_OUT)

    }

}