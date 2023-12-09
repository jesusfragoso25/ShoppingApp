package com.example.shoppingapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.R
import com.example.shoppingapp.ui.viewmodel.ClientViewModel

class gestionClient : AppCompatActivity() {

        private lateinit var clientViewModel: ClientViewModel

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_gestion_client)

            val btnAdd = findViewById<Button>(R.id.add)
            val btnDel = findViewById<Button>(R.id.delete)
            val btnEdti = findViewById<Button>(R.id.edit)





            clientViewModel = ViewModelProvider(this).get(ClientViewModel::class.java)
            clientViewModel.userList.observe(this) { userList ->
                Log.d("Data", userList.toString())
            }
            clientViewModel.showUsers()
        }
    }
