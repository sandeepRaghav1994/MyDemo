package com.example.sandeepdemo.data.repository

import com.example.sandeepdemo.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getCountries() = apiHelper.getCountries()
}