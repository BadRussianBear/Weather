package com.example.data

import com.example.data.features.main.remote.remoteEntity.CityListList
import com.example.data.features.main.remote.remoteEntity.CityListResponse
import com.example.data.features.weather.remote.remoteEntity.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface RestApi {

    @GET
    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Accept: application/json"
    )
    suspend fun getWeather(
        @Url url: String,
    ): WeatherResponse

    @GET
    @Headers(
        "Content-Type: application/json;charset=utf-8",
        "Accept: application/json"
    )
    suspend fun getCityList(
        @Url url: String
    ): List<CityListResponse>
}