package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class RealFeelTemperatureShade (
    @SerializedName("Minimum") val minimum : Minimum,
    @SerializedName("Maximum") val maximum : Maximum
)