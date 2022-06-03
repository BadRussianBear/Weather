package com.example.data.features.main.mapper

import com.example.data.base.Mapper
import com.example.data.features.main.remote.remoteEntity.CityListList
import com.example.data.features.main.remote.remoteEntity.CityListResponse
import com.example.domain.features.main.City
import javax.inject.Inject

class CityListMapper @Inject constructor() : Mapper<CityListResponse, City>() {
    override fun map(input: CityListResponse): City {
        return City(
            keyId = input.key,
            name = input.localizedName,
            isSelected = false,
        )
    }
}