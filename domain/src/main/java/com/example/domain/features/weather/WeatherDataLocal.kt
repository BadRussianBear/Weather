package com.example.domain.features.weather

data class WeatherDataLocal(
    val max: Int,
    val min: Int,
    val dateEpoch: Long,
    val dayLongPhrase: String,
    val dayWindSpeed: Double,
    val dayWindGusts: Double,
    val dayThunderstormProbability: Int,
    val dayCloudCover: Double,
    val dayRealFeel: Int,
    val dayRealFeelPhrase: String,
    val dayPrec: Boolean,
    val nightLongPhrase: String,
    val nightWindSpeed: Double,
    val nightWindGusts: Double,
    val nightThunderstormProbability: Int,
    val nightCloudCover: Double,
    val nightRealFeel: Int,
    val nightRealFeelPhrase: String,
    val nightPrec: Boolean
)