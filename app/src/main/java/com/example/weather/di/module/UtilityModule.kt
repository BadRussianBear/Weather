package com.example.weather.di.module

import com.example.domain.SharedPrefsManager
import com.example.presentation.resourcemanager.ResourceManager
import com.example.presentation.resourcemanager.ResourceManagerImpl
import com.example.weather.preference.SharedPrefsManagerImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UtilityModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideResourceManager(resourceManager: ResourceManagerImpl): ResourceManager {
        return resourceManager
    }

    @Provides
    @Singleton
    @JvmStatic
    fun gson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    @JvmStatic
    fun providePreference(sharedPrefsManagerImpl: SharedPrefsManagerImpl): SharedPrefsManager {
        return sharedPrefsManagerImpl
    }

}