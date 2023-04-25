package com.yuvesh.cpu_zassignmnet

import android.Manifest.permission.READ_PHONE_STATE
import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.*
import android.provider.Settings
import android.telephony.TelephonyManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.math.pow


class DeviceFragment : Fragment() {

    private lateinit var manufacturer: TextView

    //private lateinit var modelName: TextView
    private lateinit var modelNumber: TextView
    private lateinit var ram: TextView
    //private lateinit var storage: TextView
    lateinit var imei:TextView





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_device, container, false)


        manufacturer = view.findViewById(R.id.manufacturerText)
        modelNumber = view.findViewById(R.id.modelNumber)
        ram = view.findViewById(R.id.ram)
        imei=view.findViewById(R.id.imei)
        //storage = view.findViewById(R.id.storage)
       // androidVersion = view.findViewById(R.id.androidVersion)


            /*  val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        val ram = Runtime.getRuntime().totalMemory() / (1024 * 1024)
        val storage = context?.let { getTotalInternalStorage(it) }
        val batteryLevel = context?.let { getBatteryLevel(it) }
        val androidVersion = Build.VERSION.RELEASE
*/
       // getSystemDetail()
        manufacturer.text = "Brand: ${Build.BRAND}"
        modelNumber.text = "Model: ${Build.MODEL}"
        ram.text = "RAM: ${getTotalMemory()} MB"
       // imei.text="IMEI:${getIMEI()}"
      //  storage.text = "Storage: ${getTotalInternalStorage(requireContext())}"
       // androidVersion.text = "Android Version: ${Build.VERSION.RELEASE}"


        return view
    }

    private fun getTotalMemory(): Long {
        val mi = ActivityManager.MemoryInfo()
        val activityManager = context?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(mi)
        return mi.totalMem / (1024 * 1024)
    }



   // @SuppressLint("HardwareIds")
  /*  private fun getSystemDetail():String {
        val context=applicationContext
        return "Brand: ${Build.BRAND} \n" +
                "DeviceID: ${
                    Settings.Secure.getString(
                        contentResolver,
                        Settings.Secure.ANDROID_ID
                    )
                } \n" +
                "Model: ${Build.MODEL} \n" +
                "ID: ${Build.ID} \n" +
                "SDK: ${Build.VERSION.SDK_INT} \n" +
                "Manufacture: ${Build.MANUFACTURER} \n" +
                "Brand: ${Build.BRAND} \n" +
                "User: ${Build.USER} \n" +
                "Type: ${Build.TYPE} \n" +
                "Base: ${Build.VERSION_CODES.BASE} \n" +
                "Incremental: ${Build.VERSION.INCREMENTAL} \n" +
                "Board: ${Build.BOARD} \n" +
                "Host: ${Build.HOST} \n" +
                "FingerPrint: ${Build.FINGERPRINT} \n" +
                "Version Code: ${Build.VERSION.RELEASE}"
    }
    */



    private fun getTotalInternalStorage(context: Context): String {
        val stat = StatFs(Environment.getDataDirectory().path)
        val blockSize = stat.blockSizeLong
        val totalBlocks = stat.blockCountLong
        val totalSize = totalBlocks * blockSize
        return formatSize(totalSize)
    }

    fun formatSize(size: Long): String {
        if (size <= 0) return "0 B"
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
        return String.format(Locale.getDefault(), "%.1f %s", size / 1024.0.pow(digitGroups.toDouble()), units[digitGroups])

    }

    private fun getBatteryLevel(context: Context): Int {
        val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        return batteryLevel
    }

    //@RequiresApi(Build.VERSION_CODES.O)
   /* private fun getIMEI(): String {

       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_PHONE_STATE),
                    PERMISSION_REQUEST_READ_PHONE_STATE
                )
            } else {
                getIMEI()
            }
        } else {
            getIMEI()
        }*/

         val telephonyManager = context?.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
         return telephonyManager.imei
     }*/







}



