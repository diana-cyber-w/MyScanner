package com.example.myscanner

import android.content.Context
import com.example.myscanner.data.di.DataModule
import com.example.myscanner.domain.di.DomainModule
import com.example.myscanner.presentation.MainFragment
import com.example.myscanner.presentation.ScannerFragment
import com.example.myscanner.presentation.ScannerHistoryFragment
import com.example.myscanner.presentation.di.ViewModelModule
import com.example.myscanner.utils.di.UtilsModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class,
        UtilsModule::class
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
    fun inject(mainFragment: MainFragment)
}