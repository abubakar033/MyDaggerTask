package com.example.modulea.model

import com.google.gson.annotations.SerializedName


data class UniversityDTO(
    @SerializedName("country") val country: String? = null,
     @SerializedName("web_pages") val webPages: List<String> = emptyList(),
    @SerializedName("alpha_two_code") val alphaTwoCode: String,
     @SerializedName("domains") val domains: List<String> = emptyList(),
    @SerializedName("state-province") val stateProvince: String? = null,
    @SerializedName("name") val name: String? = null
)