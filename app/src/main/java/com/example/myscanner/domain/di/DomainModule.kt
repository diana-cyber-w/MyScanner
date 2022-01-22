package com.example.myscanner.domain.di

import com.example.myscanner.domain.ScannerInteractor
import com.example.myscanner.domain.ScannerInteractorImpl
import com.example.myscanner.repository.DataRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesScannerInteractor(
        dataRepositoryImpl: DataRepositoryImpl
    ): ScannerInteractor =
        ScannerInteractorImpl(
            dataRepositoryImpl = dataRepositoryImpl
        )
}