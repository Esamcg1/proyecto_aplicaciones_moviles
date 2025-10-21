package com.example.myapplication.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val phone: String,
    val avatarUrl: String // se deja estatico
) : Parcelable
