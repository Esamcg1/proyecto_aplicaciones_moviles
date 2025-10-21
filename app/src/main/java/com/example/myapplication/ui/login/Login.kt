package com.example.myapplication.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.ui.dashboard.DashboardActivity
import com.example.myapplication.ui.profile.ProfileActivity

class Login : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val user = findViewById<EditText>(R.id.user)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)

        // ver el  el resultado del login desde el veiwmodel
        loginViewModel.loginResult.observe(this, Observer { loginResult ->
            if (loginResult.success) {
                Toast.makeText(this, "¡Login exitoso!", Toast.LENGTH_SHORT).show()

                if (loginResult.isFirstLogin) {
                    // si es el primer login se dirige a la pantalla de inicio
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                } else {
                    // Si es un usuario recurrente se va al dashboard
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                }
                finish() // Cierra la actividad de login para que el usuario no pueda volver
            } else {
                Toast.makeText(this, loginResult.error, Toast.LENGTH_SHORT).show()
            }
        })

        // Al hacer clic manda ar llamar al método del ViewModel
        login.setOnClickListener{
            val valUser = user.text.toString()
            val valPassword = password.text.toString()
            loginViewModel.login(valUser, valPassword)
        }
    }
}