package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.myapplication.ui.profile.ProfileActivity
import com.google.android.material.card.MaterialCardView

class DashboardActivity : AppCompatActivity() {
    private lateinit var dashboardContainer: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        dashboardContainer = findViewById(R.id.dashboardContainer)

        val opciones = listOf(
            "Perfil",
            "Cambio de contraseña",
            "Productos",
            "Carrito",
            "Solicitar cotización"
        )

        var previousId: Int? = null
        for ((index, opcion) in opciones.withIndex()) {
            val cardView = createCard(opcion, index)

            dashboardContainer.addView(cardView)

            val constraintSet = ConstraintSet()
            constraintSet.clone(dashboardContainer)

            constraintSet.connect(
                cardView.id,
                ConstraintSet.START,
                ConstraintSet.PARENT_ID,
                ConstraintSet.START,
                0
            )
            constraintSet.connect(
                cardView.id,
                ConstraintSet.END,
                ConstraintSet.PARENT_ID,
                ConstraintSet.END,
                0
            )

            if (previousId == null) {
                constraintSet.connect(
                    cardView.id,
                    ConstraintSet.TOP,
                    ConstraintSet.PARENT_ID,
                    ConstraintSet.TOP,
                    16
                )
            } else {
                constraintSet.connect(
                    cardView.id,
                    ConstraintSet.TOP,
                    previousId,
                    ConstraintSet.BOTTOM,
                    16
                )
            }

            constraintSet.applyTo(dashboardContainer)
            previousId = cardView.id
        }
    }

    private fun createCard(optionText: String, index: Int): MaterialCardView {
        val cardView = MaterialCardView(this).apply {
            id = View.generateViewId()
            radius = 20f
            cardElevation = 6f
            setContentPadding(40, 60, 40, 60)
            layoutParams = ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
            )
        }

        val textView = TextView(this).apply {
            id = View.generateViewId()
            textSize = 18f
            textAlignment = View.TEXT_ALIGNMENT_CENTER
            text = optionText
        }

        cardView.addView(textView)

        cardView.setOnClickListener {
            when (optionText) {
                "Perfil" -> startActivity(Intent(this, ProfileActivity::class.java))
                else -> {
                    // T
                }
            }
        }

        return cardView
    }
}