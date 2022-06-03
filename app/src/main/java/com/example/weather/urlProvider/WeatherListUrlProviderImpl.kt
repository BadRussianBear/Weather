package com.example.weather.urlProvider

import com.example.data.features.weather.WeatherListUrlProvider
import com.example.weather.BuildConfig
import java.net.URL
import javax.inject.Inject

class WeatherListUrlProviderImpl @Inject constructor() : WeatherListUrlProvider {

    override fun provideWeatherListAPI(cityId: Int): URL {
        return URL(getWeatherListBaseURL(cityId))
    }

    private fun getWeatherListBaseURL(cityId: Int): String {
        return "${BuildConfig.SOME_URL}/forecasts/v1/daily/5day/$cityId?details=true"
    }
}