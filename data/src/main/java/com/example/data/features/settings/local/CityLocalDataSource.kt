package com.example.data.features.settings.local

import com.example.data.features.settings.local.db.CityEntity

interface CityLocalDataSource {
    suspend fun getCityListFromDb() : List<CityEntity>
    suspend fun getCityFromDb() : CityEntity
    suspend fun changeSelectedCity(keyId: Int)
}