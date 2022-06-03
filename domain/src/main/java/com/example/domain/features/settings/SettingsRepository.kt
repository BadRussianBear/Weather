package com.example.domain.features.settings

interface SettingsRepository {
    suspend fun getCityFromDb(): CityDataLocal
    suspend fun getCityListFromDb(): List<CityDataLocal>
    suspend fun changeSelectedCity(keyId: Int)
}