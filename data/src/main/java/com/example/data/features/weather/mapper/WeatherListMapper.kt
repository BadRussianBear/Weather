package com.example.data.features.weather.mapper

import com.example.presentation.R
import com.example.data.base.Mapper
import com.example.data.features.weather.remote.remoteEntity.WeatherResponse
import com.example.domain.features.weather.WeatherDataRemote
import javax.inject.Inject

class WeatherListMapper @Inject constructor() : Mapper<WeatherResponse, WeatherDataRemote>() {
    override fun map(input: WeatherResponse): WeatherDataRemote {
        val weather = mutableListOf<WeatherDataRemote.Weather>()
        input.dailyForecasts.forEach { data ->
            weather.add(
                WeatherDataRemote.Weather(
                dateEpoch = data.date,
                max = data.temperature.maximum.value ?: -999,
                min = data.temperature.minimum.value ?: -999,
                date = data.epochDate,
                dayPrec = data.day.hasPrecipitation,
                nightPrec = data.night.hasPrecipitation
            ))
        }
        return WeatherDataRemote(weather)
    }
}