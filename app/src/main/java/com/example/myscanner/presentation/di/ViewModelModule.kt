package com.example.myscanner.presentation.di

import com.example.myscanner.domain.ScannerInteractor
import com.example.myscanner.presentation.SharedViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun providesSharedViewModel(
        interactor: ScannerInteractor
    ): SharedViewModel =
        SharedViewModel(scannerInteractor = interactor)
}