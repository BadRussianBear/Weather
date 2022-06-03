package com.example.data.features.main.local

import com.example.data.CityDao
import com.example.data.features.settings.local.db.CityEntity
import javax.inject.Inject

class MainCityLocalDataSourceImpl @Inject constructor(
    private val dao: CityDao
) : MainCityLocalDataSource {

    override suspend fun saveCityListToDb(list: List<CityEntity>) {
        dao.addCityList(list)
        dao.addCity(CityEntity(
            name = "Samara",
            keyId = 290396,
            isSelected = true
        ))
    }
}