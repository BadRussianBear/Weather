package com.example.presentation.features.weatherList

import java.time.OffsetDateTime

sealed class WeatherItem(val id: String, val viewType: ViewType) {
    enum class ViewType { WEATHER , DIVIDER}

    object Divider : WeatherItem("id-news-item-view-divider", ViewType.DIVIDER)

    data class Weather(
        val articleId: String,
        val dateEpoch: Long,
        val tMin: String,
        val tMax: String,
        val date: OffsetDateTime,
        val dayIcon: Int,
        val nightIcon: Int
    ) : WeatherItem(articleId, ViewType.WEATHER)

}