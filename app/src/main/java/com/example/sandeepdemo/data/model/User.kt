package com.example.sandeepdemo.data.model

data class CountryResp(
 val error : Boolean,
     val msg : String,
 val data : List<Data>
)

data class Data(
 val iso2 : String,
 val iso3 : String,
 val country : String,
 val cities : List<String>
)

