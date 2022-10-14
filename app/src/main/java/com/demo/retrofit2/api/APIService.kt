package com.demo.retrofit2.api

import com.demo.retrofit2.model.SinhVien
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("demo1.json")
    suspend fun getdata(): Response<SinhVien>

}