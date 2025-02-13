package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.ejercicio2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import org.w3c.dom.Text

class FrameLayoutActivityEMPV : AppCompatActivity() {

    var oneGreeting : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_frame_layout_empv)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainFrameLayoutEMPV)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvHiDog = findViewById<TextView>(R.id.tvHiDogEMPV)
        val btnHiDog = findViewById<Button>(R.id.btnHiDogEMPV)
        val btnExitFLEMPV = findViewById<Button>(R.id.btnExitFLEMPV)
        btnHiDog.setOnClickListener {
            if(oneGreeting) {
                val name = tvHiDog.text
                tvHiDog.text = "Hola, $name"
            }
            oneGreeting = false
        }

        btnExitFLEMPV.setOnClickListener{
            finish()
        }
    }
}