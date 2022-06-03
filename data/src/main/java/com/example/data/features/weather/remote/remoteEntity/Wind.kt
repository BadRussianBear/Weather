package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Wind (
    @SerializedName("Speed") val speed : Speed,
    @SerializedName("Direction") val direction : Direction
)