package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Moon (
	@SerializedName("Rise") val rise : String,
	@SerializedName("EpochRise") val epochRise : Int,
	@SerializedName("Set") val set : String,
	@SerializedName("EpochSet") val epochSet : Int,
	@SerializedName("Phase") val phase : String,
	@SerializedName("Age") val age : Int
)