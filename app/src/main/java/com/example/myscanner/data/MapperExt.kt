package com.example.myscanner.data

import com.example.myscanner.data.storage.ScannerEntity
import com.example.myscanner.domain.Scan

fun ScannerEntity.toScan() =
    Scan(
        text = text,
        date = date
    )

fun Scan.toScannerEntity() =
    ScannerEntity(
        text = text,
        date = date
    )