package com.example.shoppingapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.shoppingapp.R

class HomeAdmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnCreateUser = findViewById<Button>(R.id.clientes)
        val btnCreateProduct = findViewById<Button>(R.id.productos)

        btnCreateUser.setOnClickListener{
            val intent2 = Intent(this, gestionClient::class.java)
            startActivity(intent2)
        }

        btnCreateProduct.setOnClickListener{
            val intent3 = Intent(this, gestionProducts::class.java)
            startActivity(intent3)
        }

    }
}