package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class DegreeDaySummary (
    @SerializedName("Heating") val heating : Heating,
    @SerializedName("Cooling") val cooling : Cooling
)