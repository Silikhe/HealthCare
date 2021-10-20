package com.silikhe.healthcare.ui.Hospital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.silikhe.healthcare.R


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.silikhe.healthcare.R.layout.activity_home)


        val fab: View = findViewById(R.id.hosDialog)
        fab.setOnClickListener { view ->
            val hospitalDialog = HospitalDialog()
                hospitalDialog.show(supportFragmentManager, "Story Dialog")
        }
    }

//    override fun onClick(view: View?) {
//        when(view?.id){
//            R.id.hosDialog->{
//                val storyDialogue = HospitalDialog()
//                storyDialogue.show(supportFragmentManager, "Story Dialog")
//            }
//        }
//    }
//    val fab = findViewById(R.id.hosDialog)
//    fab.setOnClickListener { view ->
//        Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
//            .setAction("Action", null)
//            .show()
//    }


}