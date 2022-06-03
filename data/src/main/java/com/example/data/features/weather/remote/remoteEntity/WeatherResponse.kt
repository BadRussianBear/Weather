package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class WeatherResponse (
    @SerializedName("Headline") val headline : Headline,
    @SerializedName("DailyForecasts") val dailyForecasts : List<DailyForecasts>
)