package com.example.data.features.weather.mapper

import com.example.data.base.Mapper
import com.example.data.features.weather.local.db.WeatherEntity
import com.example.data.features.weather.remote.remoteEntity.WeatherResponse
import javax.inject.Inject

class WeatherListDBMapper @Inject constructor() : Mapper<Pair<WeatherResponse, Int>, List<WeatherEntity>>() {
    override fun map(input: Pair<WeatherResponse, Int>): List<WeatherEntity> {
        val result: MutableList<WeatherEntity> = mutableListOf()
        input.first.dailyForecasts.map {
            result.add(
                WeatherEntity(
                    cityId = input.second,
                    max = it.temperature.maximum.value ?: -999,
                    min = it.temperature.minimum.value ?: -999,
                    dateEpoch = it.epochDate,
                    dayLongPhrase = it.day.longPhrase,
                    dayWindSpeed = it.day.wind.speed.value ?: -999.0,
                    dayWindGusts = it.day.windGust.speed.value ?: -999.0,
                    dayThunderstormProbability = it.day.thunderstormProbability ?: -999,
                    dayCloudCover = it.day.cloudCover,
                    dayRealFeel = it.realFeelTemperature.maximum.value ?: -999,
                    dayRealFeelPhrase = it.realFeelTemperature.maximum.phrase,
                    dayPrec = it.day.hasPrecipitation,
                    nightLongPhrase = it.night.longPhrase,
                    nightWindSpeed = it.night.wind.speed.value ?: -999.0,
                    nightWindGusts = it.night.windGust.speed.value ?: -999.0,
                    nightThunderstormProbability = it.night.thunderstormProbability ?: -999,
                    nightCloudCover = it.night.cloudCover,
                    nightRealFeel = it.realFeelTemperature.minimum.value ?: -999,
                    nightRealFeelPhrase = it.realFeelTemperature.minimum.phrase,
                    nightPrec = it.night.hasPrecipitation
                )
            )
        }
        return result
    }
}