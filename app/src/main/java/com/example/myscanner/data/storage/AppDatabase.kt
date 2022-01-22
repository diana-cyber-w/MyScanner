package com.example.myscanner.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        ScannerEntity::class
    ],
    version = AppDatabase.VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val VERSION = 1
    }

    abstract fun getScannerDao(): ScannerDao
}