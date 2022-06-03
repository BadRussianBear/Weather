package com.example.data.features.main.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Imperial (

	@SerializedName("Value") val value : Int,
	@SerializedName("Unit") val unit : String,
	@SerializedName("UnitType") val unitType : Int
)