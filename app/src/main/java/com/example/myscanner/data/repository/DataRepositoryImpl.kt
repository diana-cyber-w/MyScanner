package com.example.myscanner.data.repository

import com.example.myscanner.data.storage.ScannerDao
import com.example.myscanner.domain.Scan
import com.example.myscanner.utils.toScan
import com.example.myscanner.utils.toScannerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val scannerDao: ScannerDao
) : DataRepository {

    override suspend fun getScan(): List<Scan> {
        return withContext(Dispatchers.IO) {
            scannerDao.getAll().map { scannerEntity -> scannerEntity.toScan() }
        }
    }

    override suspend fun insertScan(scan: Scan) {
        withContext(Dispatchers.IO) {
            scannerDao.insertScan(scan.toScannerEntity())
        }
    }
}