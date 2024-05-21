package com.example.mytask.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.modulea.data.db.entity.UniversityEntity
@Dao
interface UniversityDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCountries(countries: UniversityEntity)

    @Query("SELECT * FROM university_table")
    suspend fun getUniversities(): UniversityEntity
}