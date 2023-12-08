package com.example.shoppingapp.data.repository

import android.telecom.CallScreeningService.CallResponse
import com.example.shoppingapp.data.remote.AuthApi
import retrofit2.Call

class UserRepository {
    val auth = AuthApi().getService()

     fun loginRepository(email: String, password: String): Call<CallResponse> {
        return auth.loginUser(email,password)
    }
    fun registerRepostory (name: String, email: String, password: String): Call<CallResponse> {
        return auth.registerUser(name,email,password)
    }
}