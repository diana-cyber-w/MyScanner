package com.example.myscanner.presentation.di

import com.example.myscanner.domain.ScannerInteractor
import com.example.myscanner.presentation.ScannerHistoryViewModel
import com.example.myscanner.presentation.ScannerViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesScannerViewModel(
        interactor: ScannerInteractor
    ): ScannerViewModel =
        ScannerViewModel(scannerInteractor = interactor)

    @Provides
    fun providesScannerHistoryViewModel(
        interactor: ScannerInteractor
    ): ScannerHistoryViewModel =
        ScannerHistoryViewModel(scannerInteractor = interactor)
}