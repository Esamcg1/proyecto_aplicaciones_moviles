package com.example.myapplication.ui.password

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapplication.R

class ChangePasswordActivity : AppCompatActivity() {

    private val viewModel: ChangePasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        val currentPassword = findViewById<EditText>(R.id.currentPassword)
        val newPassword = findViewById<EditText>(R.id.newPassword)
        val confirmNewPassword = findViewById<EditText>(R.id.confirmNewPassword)
        val saveButton = findViewById<Button>(R.id.savePasswordButton)

        viewModel.changePasswordResult.observe(this, Observer { result ->
            if (result.success) {
                Toast.makeText(this, "Contraseña cambiada con éxito", Toast.LENGTH_SHORT).show()
                finish() // Cierra la actividad si el cambio fue exitoso
            } else {
                Toast.makeText(this, result.error, Toast.LENGTH_LONG).show()
            }
        })

        saveButton.setOnClickListener {
            val current = currentPassword.text.toString()
            val new = newPassword.text.toString()
            val confirm = confirmNewPassword.text.toString()
            viewModel.changePassword(current, new, confirm)
        }
    }
}