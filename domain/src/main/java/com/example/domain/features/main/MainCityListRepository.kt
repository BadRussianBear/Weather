package com.example.domain.features.main

interface MainCityListRepository {
    suspend fun getCityList(): List<City>
}