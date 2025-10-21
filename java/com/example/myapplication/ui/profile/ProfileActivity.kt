package com.example.myapplication.ui.profile

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.data.model.User
import com.example.myapplication.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels()
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.lifecycleOwner = this

        userViewModel.user.observe(this, Observer { user ->
            binding.user = user
        })

        binding.imgAvatar.setOnClickListener {
            showImageSourceDialog()
        }
    }

    private fun showImageSourceDialog() {
        val options = arrayOf("Tomar foto", "Elegir de galería")

        AlertDialog.Builder(this)
            .setTitle("Elige una fuente")
            .setItems(options) { dialog, which ->
                when (which) {
                    0 -> {
                        // Lógica para tomar foto
                    }
                    1 -> {
                        // Lógica para elegir de galería
                    }
                }
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}