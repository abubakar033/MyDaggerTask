package com.example.modulea.di.module

import com.example.modulea.domain.repository.UniversityRepository
import com.example.modulea.domain.usecase.AddDataInDBUseCase
import com.example.modulea.domain.usecase.LocalDataUniversitiesUseCase
import com.example.modulea.domain.usecase.SearchUniversitiesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideSearchUniversitiesUseCase(repository: UniversityRepository): SearchUniversitiesUseCase {
        return SearchUniversitiesUseCase(repository)
    }

    @Provides
    fun provideAddDataInDBUseCase(repository: UniversityRepository): AddDataInDBUseCase {
        return AddDataInDBUseCase(repository)
    }

    @Provides
    fun provideLocalDataUniversitiesUseCase(repository: UniversityRepository): LocalDataUniversitiesUseCase {
        return LocalDataUniversitiesUseCase(repository)
    }
}

