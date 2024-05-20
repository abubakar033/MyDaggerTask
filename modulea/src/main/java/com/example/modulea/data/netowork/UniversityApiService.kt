package com.example.modulea.data.netowork

import com.example.modulea.domain.model.UniversityDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApiService {

    @GET("search")
    suspend fun getUniversityList(@Query("country") country: String): Response<List<UniversityDTO>>

}


