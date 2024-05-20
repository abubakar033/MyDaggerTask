package com.example.modulea.usecase

import com.example.modulea.abstraction.repository.UniversityRepository
import com.example.modulea.model.UniversityDTO
import javax.inject.Inject

class AddDataInDBUseCase @Inject constructor(private val repository: UniversityRepository) {
    suspend fun execute(data: List<UniversityDTO>) {
        repository.addDataInDB(data)
    }
}