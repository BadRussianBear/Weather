package com.example.data.features.weather

import com.example.data.base.BaseRepository
import com.example.data.features.settings.local.CityLocalDataSource
import com.example.data.features.weather.local.WeatherListLocalDataSource
import com.example.data.features.weather.local.db.WeatherEntity
import com.example.data.features.weather.mapper.WeatherListDBMapper
import com.example.data.features.weather.mapper.WeatherListForDBMapper
import com.example.data.features.weather.mapper.WeatherListMapper
import com.example.data.features.weather.remote.WeatherListRemoteDataSource
import com.example.data.features.weather.remote.remoteEntity.WeatherResponse
import com.example.domain.features.weather.WeatherDataLocal
import com.example.domain.features.weather.WeatherDataRemote
import com.example.domain.features.weather.WeatherListRepository
import javax.inject.Inject

class WeatherListRepositoryImpl @Inject
constructor(
    private val weatherListMapper: WeatherListMapper,
    private val weatherListDBMapper: WeatherListDBMapper,
    private val weatherListForDBMapper: WeatherListForDBMapper,
    private val weatherListRemoteDataSource: WeatherListRemoteDataSource,
    private val weatherListLocalDataSource: WeatherListLocalDataSource,
    private val cityLocalDataSource: CityLocalDataSource
) : WeatherListRepository, BaseRepository() {

    override suspend fun getWeatherList(): WeatherDataRemote {
        val city = cityLocalDataSource.getCityFromDb()
        val response = handleRestResponse(weatherListRemoteDataSource.getWeatherList(city.keyId))
        addWeatherToDb(response, city.keyId)
        return parseWeatherData(response)
    }

    private suspend fun addWeatherToDb(response: WeatherResponse, cityId: Int) {
        weatherListLocalDataSource.addWeatherToDb(weatherListDBMapper.map(Pair(response, cityId)))
    }

    override suspend fun getWeatherFromDb(date: Long): WeatherDataLocal {
        return parseDBData(weatherListLocalDataSource.getWeatherFromDb(date))
    }

    private fun parseDBData(weatherFromDb: WeatherEntity): WeatherDataLocal {
        return weatherListForDBMapper.map(weatherFromDb)
    }

    private fun parseWeatherData(response: WeatherResponse): WeatherDataRemote {
        return weatherListMapper.map(response)
    }
}