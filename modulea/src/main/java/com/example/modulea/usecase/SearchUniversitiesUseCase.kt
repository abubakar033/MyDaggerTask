package com.example.modulea.usecase

import com.example.modulea.model.UniversityDTO
import com.example.modulea.abstraction.repository.UniversityRepository
import retrofit2.Response
import javax.inject.Inject

class SearchUniversitiesUseCase @Inject constructor(private val universityRepository: UniversityRepository) {
    suspend operator fun invoke(country: String): Response<List<UniversityDTO>> {
        return universityRepository.searchUniversities(country)
    }
}
