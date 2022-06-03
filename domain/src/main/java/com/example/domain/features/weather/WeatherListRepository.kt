package com.example.domain.features.weather

interface WeatherListRepository {
    suspend fun getWeatherList(): WeatherDataRemote
    suspend fun getWeatherFromDb(date: Long): WeatherDataLocal
}