package com.example.modulea.di.module

import com.example.modulea.domain.repository.UniversityRepository
import com.example.modulea.domain.repositoryimp.UniversityRepositoryImpl
import com.example.modulea.data.netowork.UniversityApiService
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

