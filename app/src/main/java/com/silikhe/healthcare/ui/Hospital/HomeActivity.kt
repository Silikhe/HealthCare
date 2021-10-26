package com.silikhe.healthcare.ui.Hospital

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.drawerlayout.widget.DrawerLayout.DrawerListener
import com.google.android.material.navigation.NavigationView
import java.security.AccessController.getContext
import androidx.core.view.GravityCompat
import android.widget.Toolbar
import android.content.Intent
import androidx.annotation.NonNull
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.silikhe.healthcare.R
import android.app.PendingIntent.getActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController


class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    getSupportFragmentManager().beginTransaction().add(R.id.donRl, HomeFragment()).commit()
//                    val intent = Intent(this, HomeFragment::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                    startActivity(intent)
//                    Toast.makeText(this, "Available Blogs !", Toast.LENGTH_LONG).show();

                }
                R.id.donations -> {
                    getSupportFragmentManager().beginTransaction().add(R.id.donRl, HomeFragment()).commit()

//                    val intent = Intent(this, OrdersFragment::class.java)
//                    startActivity(intent)
//                    Toast.makeText(this, "Available Blogs !", Toast.LENGTH_LONG).show();

                }
                R.id.orders -> {
//                    val intent = Intent(this, DisperchFragment::class.java)
//                    startActivity(intent)
                    Toast.makeText(this, "Available Blogs !", Toast.LENGTH_LONG).show();
                }

            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navigation = findViewById<View>(R.id.bottomNavigationView) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fab: View = findViewById(R.id.hosDialog)
        fab.setOnClickListener { view ->
            val hospitalDialog = HospitalDialog()
            hospitalDialog.show(supportFragmentManager, "Story Dialog")
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawer, R.string.open, R.string.close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)

        drawer.addDrawerListener(object : DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                Log.i(TAG, "onDrawerSlide");
            }

            override fun onDrawerOpened(drawerView: View) {
                Log.i(TAG, "onDrawerOpened")
            }

            override fun onDrawerClosed(drawerView: View) {
                Log.i(TAG, "onDrawerClosed")
            }

            override fun onDrawerStateChanged(newState: Int) {
                Log.i(TAG, "onDrawerStateChanged");
            }
        })

    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_drawer_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        return if (id == R.id.nav_gallery) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.nav_home) {
        } else if (id == R.id.nav_gallery) {
        } else if (id == R.id.nav_tools) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


    fun openCloseNavigationDrawer(view: View) {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            drawer.openDrawer(GravityCompat.START)
        }
    }


}