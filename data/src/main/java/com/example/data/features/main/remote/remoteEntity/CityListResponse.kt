package com.example.data.features.main.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class CityListList (
	val list: List<CityListResponse>
)

data class CityListResponse (

	@SerializedName("Version") val version : Int,
	@SerializedName("Key") val key : Int,
	@SerializedName("Type") val type : String,
	@SerializedName("Rank") val rank : Int,
	@SerializedName("LocalizedName") val localizedName : String,
	@SerializedName("EnglishName") val englishName : String,
	@SerializedName("PrimaryPostalCode") val primaryPostalCode : String,
	@SerializedName("Region") val region : Region,
	@SerializedName("Country") val country : Country,
	@SerializedName("AdministrativeArea") val administrativeArea : AdministrativeArea,
	@SerializedName("TimeZone") val timeZone : TimeZone,
	@SerializedName("GeoPosition") val geoPosition : GeoPosition,
	@SerializedName("IsAlias") val isAlias : Boolean,
	@SerializedName("SupplementalAdminAreas") val supplementalAdminAreas : List<SupplementalAdminAreas>,
	@SerializedName("DataSets") val dataSets : List<String>
)