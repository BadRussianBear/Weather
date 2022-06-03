package com.example.data.features.weather.local

import com.example.data.features.weather.local.db.WeatherEntity

interface WeatherListLocalDataSource {
    suspend fun addWeatherToDb(response: List<WeatherEntity>)
    suspend fun getWeatherFromDb(date: Long) : WeatherEntity
}