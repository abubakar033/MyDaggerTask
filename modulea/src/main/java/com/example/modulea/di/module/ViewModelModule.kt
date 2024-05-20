package com.example.modulea.di.module

import com.example.modulea.domain.usecase.AddDataInDBUseCase
import com.example.modulea.domain.usecase.LocalDataUniversitiesUseCase
import com.example.modulea.domain.usecase.SearchUniversitiesUseCase
import com.example.modulea.ui.ListingScreenViewModel
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

