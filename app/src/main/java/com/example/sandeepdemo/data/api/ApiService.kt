package com.example.sandeepdemo.data.api

import com.example.sandeepdemo.data.model.CountryResp
import retrofit2.http.GET

interface ApiService {

    @GET("countries")
    suspend fun getCountries(): CountryResp

}