package com.example.modulea.abstraction.repositoryimp

import com.example.modulea.model.UniversityDTO
import com.example.modulea.abstraction.repository.UniversityRepository
import com.example.modulea.model.UniversityEntity
import com.example.modulea.netowork.UniversityApiService
import com.example.mytask.db.UniversityDB
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.HttpException
import retrofit2.Response

import javax.inject.Inject

import java.io.IOException

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

