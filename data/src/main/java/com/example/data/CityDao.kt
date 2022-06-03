package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.features.settings.local.db.CityEntity

@Dao
interface CityDao {

    @Insert
    suspend fun addCityList(value: List<CityEntity>)

    @Insert
    suspend fun addCity(value: CityEntity)

    @Query("SELECT * FROM city")
    suspend fun getAllCity(): List<CityEntity>

    @Query("SELECT * FROM city WHERE isSelected == 1")
    fun getSelectedCity(): CityEntity


    @Query("UPDATE city SET isSelected = 0 WHERE isSelected == 1")
    fun resetSelectedCity()

    @Query("UPDATE city SET isSelected = 1 WHERE keyId == :keyId")
    fun setSelectedCity(keyId: Int)

}