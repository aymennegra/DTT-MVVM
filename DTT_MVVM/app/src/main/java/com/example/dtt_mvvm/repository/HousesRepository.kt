package com.example.dtt_mvvm.repository

import com.example.dtt_mvvm.network.RetroService
import com.example.dtt_mvvm.network.RetrofitInstance

class HousesRepository constructor(private val retrofitService: RetroService) {
     fun getAllHouses() = retrofitService.getHousesFromApi()
}