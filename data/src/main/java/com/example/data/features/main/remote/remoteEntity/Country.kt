package com.example.data.features.main.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Country (

	@SerializedName("ID") val iD : String,
	@SerializedName("LocalizedName") val localizedName : String,
	@SerializedName("EnglishName") val englishName : String
)