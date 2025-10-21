package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import network.ApiClient
import network.LoginRequest
import network.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user = findViewById<EditText>(R.id.user)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener{
            val valUser = user.text.toString()
            val valPassword = password.text.toString()

            if (valUser == "admin" && valPassword == "admin") {
                Toast.makeText(this@Login,"¡Login exitoso!", Toast.LENGTH_SHORT)
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }

            // ANTERIOR
            //val request = LoginRequest(valUser, valPassword)
            //val call = ApiClient.service.login(request)

            /*call.enqueue(object : Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful && response.body()?.success == true) {
                        Toast.makeText(this@Login,"¡Login exitoso!", Toast.LENGTH_SHORT)

                    } else {
                        Toast.makeText(this@Login,"Login Fallido", Toast.LENGTH_SHORT)
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, ex: Throwable) {
                    Toast.makeText(this@Login,"Error de red: ${ex.message}", Toast.LENGTH_SHORT)
                }
            })*/
        }
    }
}