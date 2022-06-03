package com.example.presentation.features.weatherList

sealed class WeatherListNavigation {
    data class OpenDetailView(val id: Long) : WeatherListNavigation()
    object OpenSettings : WeatherListNavigation()
}