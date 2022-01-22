package com.example.myscanner.domain

import com.example.myscanner.repository.DataRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScannerInteractorImpl @Inject constructor(
    private val dataRepositoryImpl: DataRepositoryImpl
) : ScannerInteractor {

    override suspend fun getScan(): List<Scan> {
        return withContext(Dispatchers.IO) {
            dataRepositoryImpl.getScan()
        }
    }

    override suspend fun insertScan(scan: Scan) {
        withContext(Dispatchers.IO) {
            dataRepositoryImpl.insertScan(scan)
        }
    }
}