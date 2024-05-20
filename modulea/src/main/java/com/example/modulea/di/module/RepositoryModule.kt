package com.example.modulea.di.module

import com.example.modulea.abstraction.repository.UniversityRepository
import com.example.modulea.abstraction.repositoryimp.UniversityRepositoryImpl
import com.example.modulea.netowork.UniversityApiService
import com.example.mytask.db.UniversityDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUniversityRepository(apiService: UniversityApiService, universityDB: UniversityDB): UniversityRepository {
        return UniversityRepositoryImpl(apiService, universityDB)
    }
}

