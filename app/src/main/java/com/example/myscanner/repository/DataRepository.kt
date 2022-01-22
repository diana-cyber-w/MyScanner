package com.example.myscanner.repository

import com.example.myscanner.domain.Scan

interface DataRepository {
    suspend fun getScan(): List<Scan>

    suspend fun insertScan(scan: Scan)
}