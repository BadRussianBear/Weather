package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Sun (
	@SerializedName("Rise") val rise : String,
	@SerializedName("EpochRise") val epochRise : Int,
	@SerializedName("Set") val set : String,
	@SerializedName("EpochSet") val epochSet : Int
)