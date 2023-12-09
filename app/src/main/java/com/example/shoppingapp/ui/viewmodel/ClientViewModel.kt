package com.example.shoppingapp.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppingapp.data.model.clients
import com.example.shoppingapp.data.model.user
import com.example.shoppingapp.data.repository.ClientRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class ClientViewModel(application: Application): AndroidViewModel(application) {
    private val repository = ClientRepository()
    private val _userList = MutableLiveData<List<clients>>()
    val userList: LiveData<List<clients>>
        get() = _userList

    fun showUsers() {
        repository.showUser().enqueue(object : Callback<List<clients>> {
            override fun onResponse(call: Call<List<clients>>, response: Response<List<clients>>) {
                if (response.isSuccessful) {
                    _userList.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<clients>>, t: Throwable) {
                Log.e("Error", "Error en la solicitud: ${t.message}")
            }
        })
    }
}