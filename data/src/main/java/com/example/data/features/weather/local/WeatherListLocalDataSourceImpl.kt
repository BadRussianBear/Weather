package com.example.data.features.weather.local

import com.example.data.WeatherDao
import com.example.data.features.weather.local.db.WeatherEntity
import javax.inject.Inject

class WeatherListLocalDataSourceImpl @Inject constructor(
    private val dao: WeatherDao
) : WeatherListLocalDataSource {

    override suspend fun addWeatherToDb(response: List<WeatherEntity>) {
        dao.nukeTable()
        dao.addWeather(response)
    }

    override suspend fun getWeatherFromDb(date: Long): WeatherEntity {
        return dao.getSelectedWeather(date)
    }
}