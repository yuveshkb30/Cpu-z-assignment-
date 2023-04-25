package com.yuvesh.cpu_zassignmnet

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var tab_viewpager = findViewById<ViewPager2>(R.id.tab_viewpager)
        var tab_tablayout = findViewById<TabLayout>(R.id.tab_tablayout)

        tab_viewpager.adapter = PagerAdapter(this)

        TabLayoutMediator(tab_tablayout, tab_viewpager) { tab, index ->

            tab.text = when (index) {

                0 -> {
                    "Device"
                }
                1 -> {
                    "System"
                }
                2 -> {
                    "Battery"
                }
                else -> {
                    throw Resources.NotFoundException("Position not found")
                }


            }

        }.attach()




    }



}