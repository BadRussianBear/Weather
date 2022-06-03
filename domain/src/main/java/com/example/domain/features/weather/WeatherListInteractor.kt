package com.example.domain.features.weather

import com.example.domain.base.BaseInteractor
import com.example.domain.base.NetworkErrorException
import com.example.domain.base.Outcome
import javax.inject.Inject

class WeatherListInteractor
    @Inject constructor(
    private val weatherListRepository: WeatherListRepository
) : BaseInteractor() {
    suspend fun getWeatherList(): Outcome<WeatherDataRemote, String> {
        return withIOContext {
            try {
                val data = weatherListRepository.getWeatherList()
                Outcome.Success(data)
            }  catch (e: NetworkErrorException) {
                Outcome.Error(e.text)
            }
        }
    }

    suspend fun getWeatherFromDb(date: Long): WeatherDataLocal {
        return weatherListRepository.getWeatherFromDb(date)
    }

}