package com.example.data.features.main.mapper

import com.example.data.base.Mapper
import com.example.data.features.main.remote.remoteEntity.CityListResponse
import com.example.data.features.settings.local.db.CityEntity
import javax.inject.Inject

class MainCityListDBMapper @Inject constructor() : Mapper<CityListResponse, CityEntity>() {
    override fun map(input: CityListResponse): CityEntity {
        return CityEntity(
            keyId = input.key,
            name = input.localizedName,
            isSelected = false
        )
    }
}