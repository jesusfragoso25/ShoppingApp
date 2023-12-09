package com.example.shoppingapp.data.remote

import com.example.shoppingapp.data.model.clients
import retrofit2.Call

import retrofit2.http.POST

interface ClientService {
    @POST("371/list")
    fun getClient(): Call<List<clients>>
}