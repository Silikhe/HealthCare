package com.silikhe.healthcare.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View


fun <A: Activity> startNewActivity(activity: Class<A>){

//    Intent(this, activity).also {
//        it.flags =  Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
//    }
}

fun View.visible(isVisible: Boolean){
    visibility =  if(isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean){
    isEnabled = enabled
}