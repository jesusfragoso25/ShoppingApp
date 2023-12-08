package com.example.shoppingapp.ui.activity

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shoppingapp.R
import com.example.shoppingapp.data.remote.AuthService
import com.example.shoppingapp.ui.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var UserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val username = findViewById<EditText>(R.id.user)
        val password = findViewById<EditText>(R.id.password)

        val user = username.text.toString()
        val pass = password.text.toString()

        loginUser(user,pass)
    }

    private fun loginUser(user:String, pass:String){
        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos campos", Toast.LENGTH_SHORT).show()
            return
        }
        UserViewModel.loginUser(user,pass)
    }
}