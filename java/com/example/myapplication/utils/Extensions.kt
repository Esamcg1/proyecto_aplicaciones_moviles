package com.example.myapplication.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.model.User

class UserViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    init {
        _user.value = User(
            id = 1,
            name = "rgonzalez",
            email = "rgonzales@example.com",
            phone = "+502 1234-5678",
            avatarUrl = "avatar_placeholder"
        )
    }
}