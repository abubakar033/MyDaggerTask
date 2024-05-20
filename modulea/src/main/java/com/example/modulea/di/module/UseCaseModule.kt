package com.example.modulea.di.module

import com.example.modulea.abstraction.repository.UniversityRepository
import com.example.modulea.usecase.AddDataInDBUseCase
import com.example.modulea.usecase.LocalDataUniversitiesUseCase
import com.example.modulea.usecase.SearchUniversitiesUseCase
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

