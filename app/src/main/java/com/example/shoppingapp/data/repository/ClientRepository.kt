package com.example.shoppingapp.data.repository

import com.example.shoppingapp.data.model.clients
import com.example.shoppingapp.data.model.user
import com.example.shoppingapp.data.remote.ClientApi
import retrofit2.Call

class ClientRepository {
    val users = ClientApi().getClient()
    fun showUser(): Call<List<clients>> {
        return users.getClient()
    }
}