package com.example.myscanner.domain

interface ScannerInteractor {
    suspend fun getScan(): List<Scan>

    suspend fun insertScan(scan: Scan)
}