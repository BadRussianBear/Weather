package com.example.data.features.weather.mapper

import com.example.data.base.Mapper
import com.example.data.features.weather.local.db.WeatherEntity
import com.example.domain.features.weather.WeatherDataLocal
import javax.inject.Inject

class WeatherListForDBMapper @Inject constructor() : Mapper<WeatherEntity, WeatherDataLocal>() {
    override fun map(input: WeatherEntity): WeatherDataLocal {
        return WeatherDataLocal(
            max = input.max,
            min = input.min,
            dateEpoch = input.dateEpoch,
            dayLongPhrase = input.dayLongPhrase,
            dayWindSpeed = input.dayWindSpeed,
            dayWindGusts = input.dayWindGusts,
            dayThunderstormProbability = input.dayThunderstormProbability,
            dayCloudCover = input.dayCloudCover,
            dayRealFeel = input.dayRealFeel,
            dayRealFeelPhrase = input.dayRealFeelPhrase,
            dayPrec = input.dayPrec,
            nightLongPhrase = input.nightLongPhrase,
            nightWindSpeed = input.nightWindSpeed,
            nightWindGusts = input.nightWindGusts,
            nightThunderstormProbability = input.nightThunderstormProbability,
            nightCloudCover = input.nightCloudCover,
            nightRealFeel = input.nightRealFeel,
            nightRealFeelPhrase = input.nightRealFeelPhrase,
            nightPrec = input.nightPrec
        )
    }
}