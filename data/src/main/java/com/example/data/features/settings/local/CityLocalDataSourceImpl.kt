package com.example.data.features.settings.local

import com.example.data.CityDao
import com.example.data.features.settings.local.db.CityEntity
import javax.inject.Inject

class CityLocalDataSourceImpl @Inject constructor(
    private val dao: CityDao
) : CityLocalDataSource {
    override suspend fun getCityListFromDb(): List<CityEntity> {
        return dao.getAllCity()
    }

    override suspend fun getCityFromDb(): CityEntity {
        return dao.getSelectedCity()
    }

    override suspend fun changeSelectedCity(keyId: Int) {
        dao.resetSelectedCity()
        dao.setSelectedCity(keyId)
    }
}