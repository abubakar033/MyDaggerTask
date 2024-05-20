package com.example.modulea.usecase

import com.example.modulea.abstraction.repository.UniversityRepository
import com.example.modulea.model.UniversityDTO
import com.example.mytask.db.UniversityDB
import javax.inject.Inject

class LocalDataUniversitiesUseCase @Inject constructor(private val repository: UniversityRepository) {
    suspend fun execute(): List<UniversityDTO> {
        return repository.getUniversityLocalData()
    }
}