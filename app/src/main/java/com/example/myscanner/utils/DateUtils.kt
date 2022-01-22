package com.example.myscanner.utils

import java.text.SimpleDateFormat
import java.util.*

private val date = getCurrentDateTime()
val dateInString = date.toString("dd/MM/yyyy HH:mm:ss")

private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

private fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}