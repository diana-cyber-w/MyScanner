package com.example.myscanner.data.repository

import com.example.myscanner.data.storage.ScannerDao
import com.example.myscanner.domain.Scan
import com.example.myscanner.data.toScan
import com.example.myscanner.data.toScannerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val scannerDao: ScannerDao
) : DataRepository {

    override fun getScan(): Flow<List<Scan>> {
        return flow {
            val scans = scannerDao.getAll().map { scannerEntity ->
                scannerEntity.toScan()
            }
            emit(scans)
        }
    }

    override suspend fun insertScan(scan: Scan) {
        withContext(Dispatchers.IO) {
            scannerDao.insertScan(scan.toScannerEntity())
        }
    }
}