package com.example.data.features.settings.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city")
data class CityEntity(

    @PrimaryKey
    @ColumnInfo(name = "keyId")
    val keyId: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "isSelected")
    val isSelected: Boolean

)