package com.example.data.features.weather.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather")
data class WeatherEntity(

	@ColumnInfo(name = "cityId")
	val cityId: Int,

	@PrimaryKey
	@ColumnInfo(name = "date")
	val dateEpoch: Long,

	@ColumnInfo(name = "maxT")
	val max: Int,

	@ColumnInfo(name = "minT")
	val min: Int,

	@ColumnInfo(name = "dayPhrase")
	val dayLongPhrase: String,

	@ColumnInfo(name = "dwSpeed")
	val dayWindSpeed: Double,

	@ColumnInfo(name = "dwGusts")
	val dayWindGusts: Double,

	@ColumnInfo(name = "dwTProb")
	val dayThunderstormProbability: Int,

	@ColumnInfo(name = "dcCover")
	val dayCloudCover: Double,

	@ColumnInfo(name = "drFeel")
	val dayRealFeel: Int,

	@ColumnInfo(name = "drFeelPhrase")
	val dayRealFeelPhrase: String,

	@ColumnInfo(name = "dayPrec")
	val dayPrec: Boolean,

	@ColumnInfo(name = "nightPhrase")
	val nightLongPhrase: String,

	@ColumnInfo(name = "nwSpeed")
	val nightWindSpeed: Double,

	@ColumnInfo(name = "nwGustsValue")
	val nightWindGusts: Double,

	@ColumnInfo(name = "nwTProb")
	val nightThunderstormProbability: Int,

	@ColumnInfo(name = "ncCover")
	val nightCloudCover: Double,

	@ColumnInfo(name = "nrFeel")
	val nightRealFeel: Int,

	@ColumnInfo(name = "nrFeelPhrase")
	val nightRealFeelPhrase: String,

	@ColumnInfo(name = "nightPrec")
	val nightPrec: Boolean
)