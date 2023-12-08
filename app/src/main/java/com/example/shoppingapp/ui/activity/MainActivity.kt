package com.example.shoppingapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.R
import com.example.shoppingapp.data.remote.AuthService
import com.example.shoppingapp.ui.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val emailEditText = findViewById<EditText>(R.id.user)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginBtn = findViewById<Button>(R.id.login)
        val registerBtn = findViewById<Button>(R.id.register)

        loginBtn.setOnClickListener {
            val userEmail = emailEditText.text.toString()
            val userPassword = passwordEditText.text.toString()
            loginUser(userEmail, userPassword, userViewModel)
        }

        registerBtn.setOnClickListener{
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String, userViewModel: UserViewModel) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa ambos campos", Toast.LENGTH_SHORT).show()
            return
        }

        userViewModel.login(email, password, context = this)
    }
}