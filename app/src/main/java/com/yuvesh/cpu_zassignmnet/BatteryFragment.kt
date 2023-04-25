package com.yuvesh.cpu_zassignmnet

import android.content.Context
import android.content.Context.BATTERY_SERVICE
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class BatteryFragment : Fragment() {


    private lateinit var batteryLevel: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_battery, container, false)

        batteryLevel=view.findViewById(R.id.batteryLevel)

        batteryLevel.text = "Battery: ${getBatteryStatus(requireContext())}"


     //  val bm = requireContext().getSystemService(BATTERY_SERVICE) as BatteryManager

        // Get the battery percentage and store it in a INT variable
       // val batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

       // val batteryManager = requireContext().getSystemService(BATTERY_SERVICE) as BatteryManager

        //val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)


        batteryLevel.text = "Battery Level: $batteryLevel%"

        return view
    }


    private fun getBatteryStatus(context: Context): String {
        val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
       // val batteryStatus = batteryManager.getIntProperty(BatteryManager.BATTERY_STATUS)

        val status = when (batteryLevel) {
            BatteryManager.BATTERY_STATUS_CHARGING -> "Charging"
            BatteryManager.BATTERY_STATUS_DISCHARGING -> "Discharging"
            BatteryManager.BATTERY_STATUS_FULL -> "Full"
            BatteryManager.BATTERY_STATUS_NOT_CHARGING -> "Not Charging"
            else -> "Unknown"
        }

        return "$batteryLevel%, $status"
    }


}
