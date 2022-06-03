package com.example.data.features.main.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class TimeZone (

	@SerializedName("Code") val code : String,
	@SerializedName("Name") val name : String,
	@SerializedName("GmtOffset") val gmtOffset : Double,
	@SerializedName("IsDaylightSaving") val isDaylightSaving : Boolean,
	@SerializedName("NextOffsetChange") val nextOffsetChange : String
)