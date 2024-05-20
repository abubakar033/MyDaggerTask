package com.example.modulea.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.modulea.domain.model.UniversityDTO
import com.example.modulea.utills.sealedclass.ApiCallState
import com.example.modulea.domain.usecase.AddDataInDBUseCase
import com.example.modulea.domain.usecase.LocalDataUniversitiesUseCase
import com.example.modulea.domain.usecase.SearchUniversitiesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListingScreenViewModel @Inject constructor(
    private val searchUniversitiesUseCase: SearchUniversitiesUseCase,
    private val addDataInDBUseCase: AddDataInDBUseCase,
    private val loadDataFromDBUseCase: LocalDataUniversitiesUseCase,
) : ViewModel() {

    private val _liveData = MutableLiveData<ApiCallState<List<UniversityDTO>>>()
    val liveData: LiveData<ApiCallState<List<UniversityDTO>>> = _liveData

    fun fetchData(name: String) {
        _liveData.value = ApiCallState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = searchUniversitiesUseCase.invoke(name)
                if (response.isSuccessful) {
                    val data = response.body() ?: emptyList()
                    _liveData.postValue(ApiCallState.Success(data))
                    addDataInDBUseCase.execute(data)
                } else {
                    val localData = loadDataFromDBUseCase.execute()
                    if (localData.isEmpty()) {
                        _liveData.postValue(ApiCallState.Error("No data available"))
                    } else {
                        _liveData.postValue(ApiCallState.Success(localData))
                    }
                }
            } catch (e: Exception) {
                // Handle error
                val errorMessage = e.message ?: "Unknown error"
                _liveData.postValue(ApiCallState.Error(errorMessage))
            }
        }
    }

}
