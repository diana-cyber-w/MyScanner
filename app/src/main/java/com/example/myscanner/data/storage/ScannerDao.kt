package com.example.myscanner.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScannerDao {

    @Query("SELECT * FROM scanner")
    fun getAll(): List<ScannerEntity>

    @Insert
    fun insertScan(scan: ScannerEntity)
}