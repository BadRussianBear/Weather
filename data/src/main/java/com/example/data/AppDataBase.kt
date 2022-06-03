package com.example.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.features.settings.local.db.CityEntity
import com.example.data.features.weather.local.db.WeatherEntity

@Database(entities = [WeatherEntity::class, CityEntity::class], version = AppDatabase.VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDao
    abstract fun getCityDao(): CityDao

    companion object {
        const val DB_NAME = "weather.db"
        const val VERSION = 1
    }
}