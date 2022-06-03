package com.example.domain.features.main

import com.example.domain.base.BaseInteractor
import com.example.domain.base.NetworkErrorException
import com.example.domain.base.Outcome
import javax.inject.Inject

class CityListInteractor
    @Inject constructor(
    private val weatherListRepository: MainCityListRepository
) : BaseInteractor() {
    suspend fun geCityList(): Outcome<List<City>, String> {
        return withIOContext {
            try {
                val data = weatherListRepository.getCityList()
                Outcome.Success(data)
            }  catch (e: NetworkErrorException) {
                Outcome.Error(e.text)
            }
        }
    }
}