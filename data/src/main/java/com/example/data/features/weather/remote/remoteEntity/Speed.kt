package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Speed (
	@SerializedName("Value") val value : Double?,
	@SerializedName("Unit") val unit : String,
	@SerializedName("UnitType") val unitType : Int
)