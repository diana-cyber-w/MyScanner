package com.example.myscanner.data.di

import android.content.Context
import androidx.room.Room
import com.example.myscanner.data.storage.AppDatabase
import com.example.myscanner.data.storage.ScannerDao
import com.example.myscanner.data.repository.DataRepository
import com.example.myscanner.data.repository.DataRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun providesDatabaseBuilder(context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "scanner"
        ).build()

    @Provides
    fun providesScannerDao(appDatabase: AppDatabase): ScannerDao =
        appDatabase.getScannerDao()

    @Provides
    fun providesDataRepositoryImpl(scannerDao: ScannerDao): DataRepository =
        DataRepositoryImpl(scannerDao = scannerDao)
}