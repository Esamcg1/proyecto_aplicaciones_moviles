package com.example.myapplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.LoginRepository

class LoginViewModel : ViewModel() {

    private val loginRepository = LoginRepository()

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(user: String, pass: String) {
        val response = loginRepository.login(user, pass)

        if (response.isSuccess) {
            _loginResult.value = LoginResult(success = true, isFirstLogin = response.isFirstLogin)
        } else {
            _loginResult.value = LoginResult(success = false, error = "Usuario o contraseña incorrectos")
        }
    }
}

// tiene la flag del primer logn
data class LoginResult(val success: Boolean, val isFirstLogin: Boolean = false, val error: String? = null)
