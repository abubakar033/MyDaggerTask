package com.example.modulea.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "university_table")
data class UniversityEntity(
    @PrimaryKey
    @SerializedName("university_api_data") val apiData: String
)

