package com.example.shoppingapp.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthApi {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://shoptest.danydev.co/api/auth/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getService():AuthService {
        return retrofit.create(AuthService::class.java)
    }

}