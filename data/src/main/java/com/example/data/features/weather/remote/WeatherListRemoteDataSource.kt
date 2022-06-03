package com.example.data.features.weather.remote

import com.example.data.base.ApiResponse
import com.example.data.features.weather.remote.remoteEntity.WeatherResponse

interface WeatherListRemoteDataSource {
    suspend fun getWeatherList(cityId: Int): ApiResponse<WeatherResponse>
}