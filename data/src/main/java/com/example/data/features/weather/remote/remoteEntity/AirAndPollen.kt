package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class AirAndPollen (
	@SerializedName("Name") val name : String,
	@SerializedName("Value") val value : Int?,
	@SerializedName("Category") val category : String,
	@SerializedName("CategoryValue") val categoryValue : Int,
	@SerializedName("Type") val type : String
)