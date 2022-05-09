package com.example.dtt_mvvm.network

import com.example.dtt_mvvm.models.HousesData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetroService {
    @Headers("Access-Key: 98bww4ezuzfePCYFxJEWyszbUXc7dxRx")
    @GET("/api/house")
    fun getHousesFromApi() : Call<List<HousesData>>
}