package com.example.myscanner.data.repository

import com.example.myscanner.domain.Scan
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun getScan(): Flow<List<Scan>>

    suspend fun insertScan(scan: Scan)
}