package com.example.data.features.main.local

import com.example.data.features.settings.local.db.CityEntity

interface MainCityLocalDataSource {
    suspend fun saveCityListToDb(list: List<CityEntity>)
}