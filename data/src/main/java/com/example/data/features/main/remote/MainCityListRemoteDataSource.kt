package com.example.data.features.main.remote

import com.example.data.base.ApiResponse
import com.example.data.features.main.remote.remoteEntity.CityListList
import com.example.data.features.main.remote.remoteEntity.CityListResponse

interface MainCityListRemoteDataSource {
    suspend fun getCityList(): ApiResponse<List<CityListResponse>>
}