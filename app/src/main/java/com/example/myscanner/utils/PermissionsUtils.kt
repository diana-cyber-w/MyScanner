package com.example.myscanner.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

private const val CAMERA_REQUEST_CODE = 1000

fun checkPermission(context: Context): Boolean {
    return ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED
}

fun requestPermission(activity: FragmentActivity) {
    ActivityCompat.requestPermissions(
        activity, arrayOf(Manifest.permission.CAMERA),
        CAMERA_REQUEST_CODE
    )
}