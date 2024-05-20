package com.example.modulea.utills.sealedclass

sealed class ApiCallState<out T> {
    data class Success<T>(val data: T) : ApiCallState<T>()
    data class Error(val message: String?) : ApiCallState<Nothing>()
    object Loading : ApiCallState<Nothing>()
}
