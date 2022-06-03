package com.example.presentation.features.weatherList

import com.example.domain.features.weather.WeatherDataRemote
import com.example.presentation.R
import com.example.presentation.base.Mapper
import com.example.presentation.base.fToC
import com.example.presentation.resourcemanager.ResourceManager
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherListMapper @Inject constructor(private val resourcesManager: ResourceManager) : Mapper<Pair<WeatherDataRemote.Weather, Boolean>, WeatherItem.Weather>() {

    override fun mapToView(input: Pair<WeatherDataRemote.Weather, Boolean>): WeatherItem.Weather {
        val dateTime = OffsetDateTime.of(LocalDateTime.ofEpochSecond(input.first.date, 0, ZoneOffset.UTC), ZoneOffset.UTC)
        return WeatherItem.Weather(
            articleId = input.first.dateEpoch + input.first.max,
            dateEpoch = input.first.date,
            tMin = getUnitString(input.first.min, input.second),
            tMax = getUnitString(input.first.max, input.second),
            date = dateTime,
            dayIcon = getDayIcon(input.first.dayPrec),
            nightIcon = getNightIcon(input.first.nightPrec)
        )
    }

    private fun getUnitString(temp: Int, unit: Boolean): String {
        val unitStr = if(unit) resourcesManager.getString(R.string.celsius) else resourcesManager.getString(R.string.fahrenheit)
        val value = if (unit) temp.fToC().roundToInt() else temp
        return "$value $unitStr"
    }


    private fun getNightIcon(input: Boolean) : Int {
        return if(input) R.drawable.weather_rainy
        else R.drawable.weather_night
    }

    private fun getDayIcon(input: Boolean) : Int {
        return if(input) R.drawable.weather_rainy
        else R.drawable.weather_sunny
    }

}