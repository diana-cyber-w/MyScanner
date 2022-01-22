package com.example.myscanner

import android.content.Context
import com.example.myscanner.data.di.DataModule
import com.example.myscanner.domain.di.DomainModule
import com.example.myscanner.presentation.ScannerFragment
import com.example.myscanner.presentation.ScannerHistoryFragment
import com.example.myscanner.presentation.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(scannerFragment: ScannerFragment)
    fun inject(scannerHistoryFragment: ScannerHistoryFragment)
}