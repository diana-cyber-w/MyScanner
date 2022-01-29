package com.example.myscanner.utils.di

import com.example.myscanner.utils.PermissionManager
import com.example.myscanner.utils.PermissionManagerImpl
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    fun providePermissionManager(): PermissionManager =
        PermissionManagerImpl()
}