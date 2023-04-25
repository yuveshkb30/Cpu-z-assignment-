package com.yuvesh.cpu_zassignmnet

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
     return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position)
        {
            0->{DeviceFragment()}
            1->{SystemFragment()}
            2->{BatteryFragment()}
            else->{throw Resources.NotFoundException("position not found")}
        }
    }
}