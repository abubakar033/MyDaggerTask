package com.example.modulea.domain.usecase

import com.example.modulea.domain.repository.UniversityRepository
import com.example.modulea.domain.model.UniversityDTO
import javax.inject.Inject

class AddDataInDBUseCase @Inject constructor(private val repository: UniversityRepository) {
    suspend fun execute(data: List<UniversityDTO>) {
        repository.addDataInDB(data)
    }
}