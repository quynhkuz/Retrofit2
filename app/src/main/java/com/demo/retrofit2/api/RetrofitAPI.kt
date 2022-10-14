package com.demo.retrofit2.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {

    var apiService : APIService = Retrofit.Builder()
        .baseUrl("https://khoapham.vn/KhoaPhamTraining/json/tien/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(APIService::class.java)
}