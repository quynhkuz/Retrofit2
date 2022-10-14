package com.demo.retrofit2.repository

import com.demo.retrofit2.api.RetrofitAPI
import com.demo.retrofit2.model.SinhVien
import retrofit2.Response

class Repository {

    suspend fun getdata():Response<SinhVien>
    {
        return RetrofitAPI.apiService.getdata()
    }
}