package com.example.shoppingapp.data.repository

import android.telecom.CallScreeningService.CallResponse
import com.example.shoppingapp.data.model.user
import com.example.shoppingapp.data.remote.AuthApi
import com.example.shoppingapp.data.remote.AuthService
import retrofit2.Call

class UserRepository {
    val AuthApi = AuthApi().getService()

    suspend fun loginUser(user: String, pass: String): Call<CallResponse> {
        return AuthApi.loginUser(user,pass)
    }
}