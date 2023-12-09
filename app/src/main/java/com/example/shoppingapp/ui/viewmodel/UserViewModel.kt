package com.example.shoppingapp.ui.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.telecom.CallScreeningService.CallResponse
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.example.shoppingapp.data.repository.UserRepository
import com.example.shoppingapp.ui.activity.HomeAdmin
import com.example.shoppingapp.ui.activity.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(aplication: Application): AndroidViewModel(aplication) {
    val repository = UserRepository()
    fun login(email: String, password: String, context: Context) {
        repository.loginRepository(email, password).enqueue(object : Callback<CallResponse> {
            override fun onResponse(call: Call<CallResponse>, response: Response<CallResponse>) {
                if (response.isSuccessful) {
                    val intent = Intent(context, HomeAdmin::class.java)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(
                        context,
                        "Error: Usuario y/o contraseña incorrectos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<CallResponse>, t: Throwable) {
                Toast.makeText(context, "Error: Digite los campos validamente ", Toast.LENGTH_SHORT)
                    .show()
                Log.e("Error", "Error en la solicitud: ${t.message}")
            }
        })
    }


    fun register(name: String, email: String, password: String, context: Context) {
        repository.registerRepostory(name, email, password)
            .enqueue(object : Callback<CallResponse> {
                override fun onResponse(
                    call: Call<CallResponse>,
                    response: Response<CallResponse>
                ) {
                    if (response.isSuccessful) {
                        navigateToMainActivity(context)
                    } else {
                        showErrorToast(context, "Algo salió mal")
                    }
                }

                override fun onFailure(call: Call<CallResponse>, t: Throwable) {
                    showErrorToast(context, "Error: Digite los campos válidamente")
                    Log.e("Error", "Error en la solicitud: ${t.message}")
                }
            })
    }

    private fun navigateToMainActivity(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

    private fun showErrorToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}

