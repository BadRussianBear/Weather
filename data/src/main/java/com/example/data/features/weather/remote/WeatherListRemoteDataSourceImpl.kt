package com.example.data.features.weather.remote

import com.example.data.RestApi
import com.example.data.base.ApiResponse
import com.example.data.features.weather.WeatherListUrlProvider
import com.example.data.features.weather.remote.remoteEntity.WeatherResponse
import javax.inject.Inject

class WeatherListRemoteDataSourceImpl @Inject constructor(
    private val restApi: RestApi,
    private val weatherUrlProvider: WeatherListUrlProvider
) : WeatherListRemoteDataSource {

    override suspend fun getWeatherList(cityId: Int): ApiResponse<WeatherResponse> {
        return try {
            val result =  restApi.getWeather(url = weatherUrlProvider.provideWeatherListAPI(cityId).toExternalForm())
            ApiResponse.Success(result)
        } catch(exception: Exception) {
            ApiResponse.Error(exception.message ?: "Some error")
        }
    }
}