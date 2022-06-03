package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.features.weather.local.db.WeatherEntity

@Dao
interface WeatherDao {

    @Insert
    suspend fun addWeather(value: List<WeatherEntity>)

    @Query("DELETE FROM weather")
    suspend fun nukeTable()

    @Query("SELECT * FROM weather WHERE date == :date")
    fun getSelectedWeather(date: Long): WeatherEntity

}