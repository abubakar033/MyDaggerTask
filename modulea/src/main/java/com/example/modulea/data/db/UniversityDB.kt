package com.example.mytask.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.modulea.data.db.entity.UniversityEntity


@Database(entities = [UniversityEntity::class], version = 1)
abstract class UniversityDB : RoomDatabase() {

    abstract fun getCountryDAO() : UniversityDAO

}