package com.demo.retrofit2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.retrofit2.model.SinhVien
import com.demo.retrofit2.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(var repository: Repository) : ViewModel() {

    private var _data : MutableLiveData<Response<SinhVien>> = MutableLiveData()
    var data : LiveData<Response<SinhVien>> = _data

    fun getdata()
    {
        viewModelScope.launch {

            var sv :Response<SinhVien> =  repository.getdata()
            _data.value = sv
        }
    }
}