package com.example.weather.di.userDataModule

import com.example.data.features.main.local.MainCityLocalDataSource
import com.example.data.features.settings.SettingsRepositoryImpl
import com.example.data.features.settings.local.CityLocalDataSource
import com.example.data.features.settings.local.CityLocalDataSourceImpl
import com.example.domain.features.settings.SettingsRepository
import com.example.weather.di.UserScope
import dagger.Binds
import dagger.Module

@Module
interface SettingsDataModule {

    @UserScope
    @Binds
    fun provideWeatherListRepo(impl: SettingsRepositoryImpl): SettingsRepository

    @UserScope
    @Binds
    fun provideCityLocalDataSource(impl: CityLocalDataSourceImpl): CityLocalDataSource

}