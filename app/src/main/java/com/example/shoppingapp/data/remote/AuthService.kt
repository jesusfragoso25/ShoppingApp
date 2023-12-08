package com.example.shoppingapp.data.remote

import android.telecom.CallScreeningService.CallResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface AuthService {
    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(@Field("user") user: String, @Field("pass") pass: String): Call<CallResponse>
    }
