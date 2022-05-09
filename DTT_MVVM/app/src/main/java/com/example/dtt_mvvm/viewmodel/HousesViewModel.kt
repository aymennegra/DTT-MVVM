package com.example.dtt_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dtt_mvvm.models.HousesData
import com.example.dtt_mvvm.network.RetroService
import com.example.dtt_mvvm.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HousesViewModel : ViewModel () {

    lateinit var RecyclerHousesLiveData : MutableLiveData<List<HousesData>>

    init{
        RecyclerHousesLiveData = MutableLiveData()
    }

    fun GetHousesListObserver(): MutableLiveData<List<HousesData>>{
            return RecyclerHousesLiveData
    }

    fun makeAPICall() {
        viewModelScope.launch(Dispatchers.IO) {
        val retroInstance = RetrofitInstance.getRetrofitInstance()
        val retroService  = retroInstance.create(RetroService::class.java)
        val call  = retroService.getHousesFromApi()
        call.enqueue(object : Callback<List<HousesData>> {
            override fun onFailure(call: Call<List<HousesData>>, t: Throwable) {
                RecyclerHousesLiveData.postValue(null)
            }

            override fun onResponse(
                call: Call<List<HousesData>>,
                response: Response<List<HousesData>>
            ) {
                RecyclerHousesLiveData.postValue(response.body())
            }
        })
    }
    }
}