package com.yuvesh.cpu_zassignmnet

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.opengl.GLES20
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.StatFs
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*
import kotlin.math.pow


class SystemFragment : Fragment() {

    private lateinit var androidVersion: TextView
    private lateinit var storage: TextView
    private lateinit var renderer: TextView
    private lateinit var vendor: TextView
    private lateinit var version: TextView
    private lateinit var extensions: TextView
    private lateinit var cameraMegapixel: TextView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_system, container, false)

        storage = view.findViewById(R.id.storage)
        androidVersion = view.findViewById(R.id.androidVersion)

        renderer = view.findViewById(R.id.renderer)
        vendor = view.findViewById(R.id.vendor)
        version = view.findViewById(R.id.version)
        extensions = view.findViewById(R.id.extensions)

        renderer.text = "Renderer: ${GLES20.glGetString(GLES20.GL_RENDERER)}"
        vendor.text = "Vendor: ${GLES20.glGetString(GLES20.GL_VENDOR)}"
        version.text = "Version: ${GLES20.glGetString(GLES20.GL_VERSION)}"
        extensions.text = "Extensions: ${GLES20.glGetString(GLES20.GL_EXTENSIONS)}"


        cameraMegapixel = view.findViewById(R.id.cameraMegapixel)
        cameraMegapixel.text = "Camera Megapixel: ${getCameraMegapixel()} MP"

        /*  val manufacturer = Build.MANUFACTURER
    val model = Build.MODEL
    val ram = Runtime.getRuntime().totalMemory() / (1024 * 1024)
    val storage = context?.let { getTotalInternalStorage(it) }
    val batteryLevel = context?.let { getBatteryLevel(it) }
    val androidVersion = Build.VERSION.RELEASE
*/
        // getSystemDetail()

        androidVersion.text = "Android Version: ${Build.VERSION.RELEASE}"
        storage.text = "Storage: ${getTotalInternalStorage(requireContext())}"


        return view
    }

    @SuppressLint("MissingPermission")
    private fun getCameraMegapixel(): Float {
        var megapixel = 0.0f
        val cameraManager = context?.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            try {
                for (cameraId in cameraManager.cameraIdList) {
                    val characteristics = cameraManager.getCameraCharacteristics(cameraId)
                    val sensorSize = characteristics.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE)
                    val pixelSize = characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE)
                    if (sensorSize != null && pixelSize != null) {
                        val area = (sensorSize.width / pixelSize.width.toFloat()) * (sensorSize.height / pixelSize.height.toFloat())
                        megapixel = area * 12
                        break
                    }
                }
            } catch (e: CameraAccessException) {
                e.printStackTrace()
            }
        }
        return megapixel
    }


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




}