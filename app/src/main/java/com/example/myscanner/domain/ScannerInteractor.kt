package com.example.myscanner.domain

import kotlinx.coroutines.flow.Flow

interface ScannerInteractor {
    fun getScan(): Flow<List<Scan>>

    suspend fun insertScan(scan: Scan)
}