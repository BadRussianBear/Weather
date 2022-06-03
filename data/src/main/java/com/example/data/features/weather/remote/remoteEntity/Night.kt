package com.example.data.features.weather.remote.remoteEntity

import com.google.gson.annotations.SerializedName

data class Night (
    @SerializedName("Icon") val icon : Int,
    @SerializedName("IconPhrase") val iconPhrase : String,
    @SerializedName("HasPrecipitation") val hasPrecipitation : Boolean,
    @SerializedName("ShortPhrase") val shortPhrase : String,
    @SerializedName("LongPhrase") val longPhrase : String,
    @SerializedName("PrecipitationProbability") val precipitationProbability : Int?,
    @SerializedName("ThunderstormProbability") val thunderstormProbability : Int?,
    @SerializedName("RainProbability") val rainProbability : Int?,
    @SerializedName("SnowProbability") val snowProbability : Int?,
    @SerializedName("IceProbability") val iceProbability : Int?,
    @SerializedName("Wind") val wind : Wind,
    @SerializedName("WindGust") val windGust : WindGust,
    @SerializedName("TotalLiquid") val totalLiquid : TotalLiquid,
    @SerializedName("Rain") val rain : Rain,
    @SerializedName("Snow") val snow : Snow,
    @SerializedName("Ice") val ice : Ice,
    @SerializedName("HoursOfPrecipitation") val hoursOfPrecipitation : Double,
    @SerializedName("HoursOfRain") val hoursOfRain : Double,
    @SerializedName("HoursOfSnow") val hoursOfSnow : Double,
    @SerializedName("HoursOfIce") val hoursOfIce : Double,
    @SerializedName("CloudCover") val cloudCover : Double,
    @SerializedName("Evapotranspiration") val evapotranspiration : Evapotranspiration,
    @SerializedName("SolarIrradiance") val solarIrradiance : SolarIrradiance
)