package com.example.modulea.di.module

import android.content.Context
import androidx.room.Room
import com.example.mytask.db.UniversityDB

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideCountryDB(context: Context): UniversityDB {
        return Room.databaseBuilder(context, UniversityDB::class.java, "UniversityDB").build()
    }
}
