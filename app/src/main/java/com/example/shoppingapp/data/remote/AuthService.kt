package com.example.shoppingapp.data.remote

import android.telecom.CallScreeningService.CallResponse
import com.example.shoppingapp.data.model.user
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface AuthService {
    @FormUrlEncoded
    @POST("login")
    fun loginUser(@Field("email") email: String, @Field("password") password: String): Call<CallResponse>
    @FormUrlEncoded
    @POST("49/register")
    fun registerUser(@Field("name") name: String,
                     @Field("email") email: String,
                     @Field("password") password: String): Call<CallResponse>

}
