package com.example.weather.urlProvider

import com.example.data.features.main.CityListUrlProvider
import com.example.weather.BuildConfig
import java.net.URL
import javax.inject.Inject

class SettingsListUrlProviderImpl @Inject constructor() : CityListUrlProvider {

    override fun provideCityListAPI(): URL {
        return URL(getCityListBaseURL())
    }

    private fun getCityListBaseURL(): String {
        return "${BuildConfig.SOME_URL}/locations/v1/topcities/50"
    }
}