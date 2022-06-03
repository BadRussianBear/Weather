package com.example.domain.features.weather

data class WeatherDataRemote(
    val weatherList: List<Weather>
) {

    data class Weather(
        val dateEpoch: String,
        val min: Int,
        val max: Int,
        val date: Long,
        val dayPrec: Boolean,
        val nightPrec: Boolean
    )
}