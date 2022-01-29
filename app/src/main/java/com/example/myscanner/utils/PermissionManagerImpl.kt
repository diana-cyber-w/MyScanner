package com.example.myscanner.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.myscanner.utils.PermissionManager.Companion.CAMERA_REQUEST_CODE
import javax.inject.Inject

class PermissionManagerImpl @Inject constructor() : PermissionManager {

    override fun requestCameraPermission(activity: Activity) {
        ActivityCompat.requestPermissions(
            activity, arrayOf(Manifest.permission.CAMERA),
            CAMERA_REQUEST_CODE
        )
    }

    override fun isCameraPermissionGranted(activity: Activity): Boolean {
        return getCameraStatus(activity)
    }

    private fun getCameraStatus(activity: Activity) = ContextCompat.checkSelfPermission(
        activity,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED

}