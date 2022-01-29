package com.example.myscanner.utils

import android.app.Activity

interface PermissionManager {

    companion object {
        const val CAMERA_REQUEST_CODE = 1000
    }

    fun requestCameraPermission(activity: Activity)

    fun isCameraPermissionGranted(activity: Activity): Boolean
}