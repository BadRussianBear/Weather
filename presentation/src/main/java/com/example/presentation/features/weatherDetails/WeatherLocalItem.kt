package com.example.presentation.features.weatherDetails

data class WeatherLocalItem(
    val max: String,
    val min: String,
    val dateEpoch: Long,
    val dayLongPhrase: String,
    val dayWindSpeed: Double,
    val dayWindGusts: Double,
    val dayThunderstormProbability: Int,
    val dayCloudCover: Double,
    val dayRealFeel: String,
    val dayRealFeelPhrase: String,
    val dayIcon: Int,
    val nightLongPhrase: String,
    val nightWindSpeed: Double,
    val nightWindGusts: Double,
    val nightThunderstormProbability: Int,
    val nightCloudCover: Double,
    val nightRealFeel: String,
    val nightRealFeelPhrase: String,
    val nightIcon: Int
)