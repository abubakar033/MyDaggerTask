package com.example.modulea.domain.usecase

import com.example.modulea.domain.repository.UniversityRepository
import com.example.modulea.domain.model.UniversityDTO
import javax.inject.Inject

class LocalDataUniversitiesUseCase @Inject constructor(private val repository: UniversityRepository) {
    suspend fun execute(): List<UniversityDTO> {
        return repository.getUniversityLocalData()
    }
}