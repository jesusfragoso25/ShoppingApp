package com.example.shoppingapp.ui.viewmodel

import android.telecom.CallScreeningService.CallResponse
import com.example.shoppingapp.data.remote.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel {

     fun loginUser(user: String, pass: String) {
        val call = AuthService.loginUser(user, pass)
        call.enqueue(object : Callback<CallResponse> {
            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>) {
                if (response.isSuccessful) {
                    println(response.body())
                } else {
                    println("Error: ${response.code()} ${response.message()}")
                }
            }
            override fun onFailure(call: Call<CallResponse>, t: Throwable) {
            }
        })

    }
}