package com.example.myapplication.ui.password

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repository.LoginRepository

class ChangePasswordViewModel : ViewModel() {

    private val loginRepository = LoginRepository()

    private val _changePasswordResult = MutableLiveData<ChangePasswordResult>()
    val changePasswordResult: LiveData<ChangePasswordResult> = _changePasswordResult

    fun changePassword(currentPass: String, newPass: String, confirmPass: String) {
        if (newPass != confirmPass) {
            _changePasswordResult.value = ChangePasswordResult(success = false, error = "Las contraseñas nuevas no coinciden")
            return
        }

        // llmar a un repo
        val isSuccess = loginRepository.changePassword(currentPass, newPass)

        if (isSuccess) {
            _changePasswordResult.value = ChangePasswordResult(success = true)
        } else {
            _changePasswordResult.value = ChangePasswordResult(success = false, error = "La contraseña actual es incorrecta")
        }
    }
}

data class ChangePasswordResult(val success: Boolean, val error: String? = null)
