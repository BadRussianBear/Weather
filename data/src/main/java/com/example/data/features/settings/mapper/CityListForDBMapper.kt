package com.example.data.features.settings.mapper

import com.example.data.base.Mapper
import com.example.data.features.settings.local.db.CityEntity
import com.example.domain.features.settings.CityDataLocal
import javax.inject.Inject

class CityListForDBMapper @Inject constructor() : Mapper<CityEntity, CityDataLocal>() {
    override fun map(input: CityEntity): CityDataLocal {
        return CityDataLocal(
            name = input.name,
            keyId = input.keyId,
            isSelected = input.isSelected
        )
    }
}