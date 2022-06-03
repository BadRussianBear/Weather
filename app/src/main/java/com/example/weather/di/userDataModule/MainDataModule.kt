package com.example.weather.di.userDataModule

import com.example.data.features.main.MainCityListRepositoryImpl
import com.example.data.features.main.local.MainCityLocalDataSource
import com.example.data.features.main.local.MainCityLocalDataSourceImpl
import com.example.data.features.main.remote.MainCityListRemoteDataSource
import com.example.data.features.main.remote.MainCityListRemoteDataSourceImpl
import com.example.data.features.settings.SettingsRepositoryImpl
import com.example.domain.features.main.MainCityListRepository
import com.example.domain.features.settings.SettingsRepository
import com.example.weather.di.UserScope
import dagger.Binds
import dagger.Module

@Module
interface MainDataModule {

    @UserScope
    @Binds
    fun provideMainCityListRepo(impl: MainCityListRepositoryImpl): MainCityListRepository

    @UserScope
    @Binds
    fun provideMainCityLocalDataSource(impl: MainCityLocalDataSourceImpl): MainCityLocalDataSource

    @UserScope
    @Binds
    fun provideCityRemoteDataSource(impl: MainCityListRemoteDataSourceImpl): MainCityListRemoteDataSource

}