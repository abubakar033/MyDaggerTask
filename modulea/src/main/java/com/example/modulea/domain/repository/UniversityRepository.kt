package com.example.modulea.domain.repository

import com.example.modulea.domain.model.UniversityDTO
import retrofit2.Response


interface UniversityRepository {
    suspend fun searchUniversities(country: String): Response<List<UniversityDTO>>
    suspend fun getUniversityLocalData(): List<UniversityDTO>
    suspend fun addDataInDB(list: List<UniversityDTO>)
}
