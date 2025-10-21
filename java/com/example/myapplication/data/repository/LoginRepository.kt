package com.example.myapplication.data.repository

// empaquetar el resultado del lgon
data class LoginResponse(val isSuccess: Boolean, val isFirstLogin: Boolean = false)

//para iteractuar con la BD o una API
class LoginRepository {

    fun login(user: String, pass: String): LoginResponse {
        // logica de negocio
        return when {
            user == "admin" && pass == "admin" -> LoginResponse(isSuccess = true, isFirstLogin = false) // Usuario existente
            user == "nuevo" && pass == "nuevo" -> LoginResponse(isSuccess = true, isFirstLogin = true)  // Nuevo usuario
            else -> LoginResponse(isSuccess = false) // Login fallido
        }
    }

    fun changePassword(currentPass: String, newPass: String): Boolean {
.
        return currentPass == "admin"
    }
}
