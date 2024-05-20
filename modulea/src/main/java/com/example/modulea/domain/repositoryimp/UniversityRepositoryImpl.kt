package com.example.modulea.domain.repositoryimp

import com.example.modulea.domain.model.UniversityDTO
import com.example.modulea.domain.repository.UniversityRepository
import com.example.modulea.data.db.entity.UniversityEntity
import com.example.modulea.data.netowork.UniversityApiService
import com.example.mytask.db.UniversityDB
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response

import javax.inject.Inject

class UniversityRepositoryImpl @Inject constructor(private val apiService: UniversityApiService
, private val universityDB: UniversityDB) :
    UniversityRepository {

    override suspend fun searchUniversities(country: String): Response<List<UniversityDTO>> {
        return  apiService.getUniversityList(country)
    }

    override suspend fun getUniversityLocalData(): List<UniversityDTO> {
        val list = universityDB.getCountryDAO().getUniversities()
        val type = object : TypeToken<List<UniversityDTO>>() {}.type
        val data: List<UniversityDTO> = Gson().fromJson(list.apiData, type)
        return data
    }

   override suspend fun addDataInDB(list: List<UniversityDTO>){
        val data  = Gson().toJson(list)
        val universityEntity = UniversityEntity(data)
        universityDB.getCountryDAO().addCountries(universityEntity)

    }

}

