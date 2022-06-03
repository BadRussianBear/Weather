package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Minimum (
	@SerializedName("Value") val value : Int?,
	@SerializedName("Unit") val unit : String,
	@SerializedName("UnitType") val unitType : Int,
	@SerializedName("Phrase") val phrase : String
)