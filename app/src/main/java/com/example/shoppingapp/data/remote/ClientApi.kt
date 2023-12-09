package com.example.shoppingapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientApi {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://shoptest.danydev.co/api/user/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getClient():ClientService {
        return retrofit.create(ClientService::class.java)
    }
}