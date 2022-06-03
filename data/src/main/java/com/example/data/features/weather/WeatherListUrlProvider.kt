package com.example.data.features.weather

import java.net.URL

interface WeatherListUrlProvider {
    fun provideWeatherListAPI(cityId: Int): URL
}