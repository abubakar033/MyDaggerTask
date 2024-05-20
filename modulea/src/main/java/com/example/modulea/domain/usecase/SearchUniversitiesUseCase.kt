package com.example.modulea.domain.usecase

import com.example.modulea.domain.model.UniversityDTO
import com.example.modulea.domain.repository.UniversityRepository
import retrofit2.Response
import javax.inject.Inject

class SearchUniversitiesUseCase @Inject constructor(private val universityRepository: UniversityRepository) {
    suspend operator fun invoke(country: String): Response<List<UniversityDTO>> {
        return universityRepository.searchUniversities(country)
    }
}
