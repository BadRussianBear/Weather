package com.example.weather.di.userDataModule

import com.example.data.features.weather.WeatherListRepositoryImpl
import com.example.data.features.weather.local.WeatherListLocalDataSource
import com.example.data.features.weather.local.WeatherListLocalDataSourceImpl
import com.example.data.features.weather.remote.WeatherListRemoteDataSource
import com.example.data.features.weather.remote.WeatherListRemoteDataSourceImpl
import com.example.domain.features.weather.WeatherListRepository
import com.example.weather.di.UserScope
import dagger.Binds
import dagger.Module

@Module
interface WeatherListDataModule {

    @UserScope
    @Binds
    fun provideWeatherListDataSource(impl: WeatherListRemoteDataSourceImpl): WeatherListRemoteDataSource

    @UserScope
    @Binds
    fun provideWeatherListRepo(impl: WeatherListRepositoryImpl): WeatherListRepository

    @UserScope
    @Binds
    fun provideWeatherListLocalDataSource(impl: WeatherListLocalDataSourceImpl): WeatherListLocalDataSource
}