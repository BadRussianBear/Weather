package com.example.weather.di.module.navigation

import com.example.domain.di.AppContext
import com.example.weather.base.LocalCiceroneHolder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object LocalNavigationModule {

    @Provides
    fun provideLocalNavigationHolder(): LocalCiceroneHolder = LocalCiceroneHolder()
}