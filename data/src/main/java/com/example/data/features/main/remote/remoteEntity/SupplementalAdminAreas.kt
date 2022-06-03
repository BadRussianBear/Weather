package com.example.data.features.main.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class SupplementalAdminAreas (

	@SerializedName("Level") val level : Int,
	@SerializedName("LocalizedName") val localizedName : String,
	@SerializedName("EnglishName") val englishName : String
)