package com.example.domain.features.settings

import com.example.domain.base.BaseInteractor
import com.example.domain.base.NetworkErrorException
import com.example.domain.base.Outcome
import javax.inject.Inject

class SettingsInteractor
    @Inject constructor(
    private val settingsRepository: SettingsRepository
) : BaseInteractor() {
    suspend fun getCityFromDb(): CityDataLocal {
        return settingsRepository.getCityFromDb()
    }

    suspend fun getCityList(): List<CityDataLocal> {
        return settingsRepository.getCityListFromDb()
    }

    suspend fun changeSelectedCity(keyId: Int) {
        return settingsRepository.changeSelectedCity(keyId)
    }

}