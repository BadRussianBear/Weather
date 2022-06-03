package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class DailyForecasts(
    @SerializedName("Date") val date: String,
    @SerializedName("EpochDate") val epochDate: Long,
    @SerializedName("Sun") val sun: Sun,
    @SerializedName("Moon") val moon: Moon,
    @SerializedName("Temperature") val temperature: Temperature,
    @SerializedName("RealFeelTemperature") val realFeelTemperature: RealFeelTemperature,
    @SerializedName("RealFeelTemperatureShade") val realFeelTemperatureShade: RealFeelTemperatureShade,
    @SerializedName("HoursOfSun") val hoursOfSun: Double,
    @SerializedName("DegreeDaySummary") val degreeDaySummary: DegreeDaySummary,
    @SerializedName("AirAndPollen") val airAndPollen: List<AirAndPollen>,
    @SerializedName("Day") val day: Day,
    @SerializedName("Night") val night: Night,
    @SerializedName("Sources") val sources: List<String>,
    @SerializedName("MobileLink") val mobileLink: String,
    @SerializedName("Link") val link: String
)