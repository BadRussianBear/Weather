package com.example.data.features.settings

import com.example.data.base.BaseRepository
import com.example.data.features.settings.local.CityLocalDataSource
import com.example.data.features.settings.mapper.CityListForDBMapper
import com.example.domain.features.settings.CityDataLocal
import com.example.domain.features.settings.SettingsRepository
import javax.inject.Inject

class SettingsRepositoryImpl @Inject
constructor(
    private val cityListForDBMapper: CityListForDBMapper,
    private val cityListLocalDataSource: CityLocalDataSource
) : SettingsRepository, BaseRepository() {

    override suspend fun getCityFromDb(): CityDataLocal {
        return cityListForDBMapper.map(cityListLocalDataSource.getCityFromDb())
    }

    override suspend fun getCityListFromDb(): List<CityDataLocal> {
        return cityListForDBMapper.mapList(cityListLocalDataSource.getCityListFromDb())
    }

    override suspend fun changeSelectedCity(keyId: Int) {
        cityListLocalDataSource.changeSelectedCity(keyId)
    }
}