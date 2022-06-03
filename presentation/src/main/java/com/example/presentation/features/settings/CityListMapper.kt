package com.example.presentation.features.settings

import com.example.domain.features.settings.CityDataLocal
import com.example.presentation.base.Mapper
import javax.inject.Inject

class CityListMapper @Inject constructor() : Mapper<CityDataLocal, CityItem.PositionItem>() {

    override fun mapToView(input: CityDataLocal): CityItem.PositionItem {
        return CityItem.PositionItem(
            keyId = input.keyId,
            name = input.name,
            isSelected = input.isSelected
        )
    }
}