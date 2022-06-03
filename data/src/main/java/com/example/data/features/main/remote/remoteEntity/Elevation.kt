package com.example.data.features.main.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Elevation (

	@SerializedName("Metric") val metric : Metric,
	@SerializedName("Imperial") val imperial : Imperial
)