package com.example.myscanner.domain

import com.example.myscanner.data.repository.DataRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ScannerInteractorImpl @Inject constructor(
    private val dataRepositoryImpl: DataRepositoryImpl
) : ScannerInteractor {

    override fun getScan(): Flow<List<Scan>> = dataRepositoryImpl.getScan()
        .flowOn(Dispatchers.IO)

    override suspend fun insertScan(scan: Scan) {
        withContext(Dispatchers.IO) {
            dataRepositoryImpl.insertScan(scan)
        }
    }
}