package com.example.data.features.main.remote

import com.example.data.RestApi
import com.example.data.base.ApiResponse
import com.example.data.features.main.CityListUrlProvider
import com.example.data.features.main.remote.remoteEntity.CityListList
import com.example.data.features.main.remote.remoteEntity.CityListResponse
import javax.inject.Inject

class MainCityListRemoteDataSourceImpl @Inject constructor(
    private val restApi: RestApi,
    private val cityrUrlProvider: CityListUrlProvider
) : MainCityListRemoteDataSource {

    override suspend fun getCityList(): ApiResponse<List<CityListResponse>> {
        return try {
            val result =  restApi.getCityList(url = cityrUrlProvider.provideCityListAPI().toExternalForm(),)
            ApiResponse.Success(result)
        } catch(exception: Exception) {
            ApiResponse.Error(exception.message ?: "Some error")
        }
    }
}