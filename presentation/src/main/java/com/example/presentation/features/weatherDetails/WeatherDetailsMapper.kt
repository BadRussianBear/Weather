package com.example.presentation.features.weatherDetails

import com.example.domain.features.weather.WeatherDataLocal
import com.example.presentation.R
import com.example.presentation.base.Mapper
import com.example.presentation.base.fToC
import com.example.presentation.resourcemanager.ResourceManager
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherDetailsMapper @Inject constructor(private val resourcesManager: ResourceManager) : Mapper<Pair<WeatherDataLocal, Boolean>, WeatherLocalItem>() {

    override fun mapToView(input: Pair<WeatherDataLocal, Boolean>): WeatherLocalItem {
        return WeatherLocalItem(
            max = getUnitString(input.first.max, input.second),
            min = getUnitString(input.first.min, input.second),
            dateEpoch = input.first.dateEpoch,
            dayLongPhrase = input.first.dayLongPhrase,
            dayWindSpeed = input.first.dayWindSpeed,
            dayWindGusts = input.first.dayWindGusts,
            dayThunderstormProbability = input.first.dayThunderstormProbability,
            dayCloudCover = input.first.dayCloudCover,
            dayRealFeel = getUnitString(input.first.dayRealFeel, input.second),
            dayRealFeelPhrase = input.first.dayRealFeelPhrase,
            dayIcon = getDayIcon(input.first.dayPrec),
            nightLongPhrase = input.first.nightLongPhrase,
            nightWindSpeed = input.first.nightWindSpeed,
            nightWindGusts = input.first.nightWindGusts,
            nightThunderstormProbability = input.first.nightThunderstormProbability,
            nightCloudCover = input.first.nightCloudCover,
            nightRealFeel = getUnitString(input.first.nightRealFeel, input.second),
            nightRealFeelPhrase = input.first.nightRealFeelPhrase,
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