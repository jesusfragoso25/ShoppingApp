package com.example.shoppingapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.shoppingapp.R
import com.example.shoppingapp.ui.viewmodel.UserViewModel

class ClienteRegister : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_register)


        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val nameEditText = findViewById<EditText>(R.id.name)
        val emailEditText = findViewById<EditText>(R.id.email)

        val passwordEditText = findViewById<EditText>(R.id.password)
        val CpasswordEditText = findViewById<EditText>(R.id.confirmpassword)

        val btnRegister = findViewById<Button>(R.id.login)
        val btnLog = findViewById<Button>(R.id.btnl)


        btnRegister.setOnClickListener{
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val cpassUser = CpasswordEditText.text.toString()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || cpassUser.isEmpty() ) {
                Toast.makeText(this, "Por favor ingresa todos los campos campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            registerUser(name,email, password,userViewModel, cpassUser)
        }

        btnLog.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser(name: String, email: String, password: String, userViewModel: UserViewModel, cpassUser: String ){
        if (password == cpassUser){
            userViewModel.register(name, email, password ,context = this)
        }else {
            Toast.makeText(this, "Tus contraseñas no coinciden", Toast.LENGTH_SHORT).show()
        }
    }
}