package com.example.modulea.viewmodel

import com.example.modulea.usecase.AddDataInDBUseCase
import com.example.modulea.usecase.LocalDataUniversitiesUseCase
import com.example.modulea.usecase.SearchUniversitiesUseCase
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideMyViewModel(
        searchUniversitiesUseCase: SearchUniversitiesUseCase,
        addDataInDBUseCase: AddDataInDBUseCase,
        loadDataFromDBUseCase: LocalDataUniversitiesUseCase
    ): ListingScreenViewModel {
        return ListingScreenViewModel(searchUniversitiesUseCase, addDataInDBUseCase, loadDataFromDBUseCase)
    }
}

