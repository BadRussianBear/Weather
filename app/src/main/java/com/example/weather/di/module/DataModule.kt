package com.example.weather.di.module

import android.content.Context
import androidx.room.Room
import com.example.data.AppDatabase
import com.example.domain.di.AppContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideDataBase(@AppContext appContext: Context): AppDatabase =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun providesWeatherDAO(db: AppDatabase) = db.getWeatherDao()

    @Singleton
    @Provides
    fun providesCityDAO(db: AppDatabase) = db.getCityDao()
}