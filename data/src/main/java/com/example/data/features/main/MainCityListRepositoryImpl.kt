package com.example.data.features.main

import com.example.data.base.BaseRepository
import com.example.data.features.main.local.MainCityLocalDataSource
import com.example.data.features.main.mapper.CityListMapper
import com.example.data.features.main.mapper.MainCityListDBMapper
import com.example.data.features.main.remote.MainCityListRemoteDataSource
import com.example.data.features.main.remote.remoteEntity.CityListList
import com.example.data.features.main.remote.remoteEntity.CityListResponse
import com.example.domain.features.main.City
import com.example.domain.features.main.MainCityListRepository
import javax.inject.Inject

class MainCityListRepositoryImpl @Inject
constructor(
    private val cityListMapper: CityListMapper,
    private val cityListDBMapper: MainCityListDBMapper,
    private val cityListRemoteDataSource: MainCityListRemoteDataSource,
    private val cityListLocalDataSource: MainCityLocalDataSource,
) : MainCityListRepository, BaseRepository() {

    override suspend fun getCityList(): List<City> {
        val response = handleRestResponse(cityListRemoteDataSource.getCityList())
        addCityListToDb(response)
        return parseCityData(response)
    }

    private fun parseCityData(response: List<CityListResponse>): List<City> {
        return cityListMapper.mapList(response)
    }

    private suspend fun addCityListToDb(response: List<CityListResponse>) {
        cityListLocalDataSource.saveCityListToDb(cityListDBMapper.mapList(response))
    }
}