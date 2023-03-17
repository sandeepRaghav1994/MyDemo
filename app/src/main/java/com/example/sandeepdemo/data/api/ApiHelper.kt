package com.example.sandeepdemo.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getCountries() = apiService.getCountries()
}