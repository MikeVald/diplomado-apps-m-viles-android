package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.ejercicio2.HomeExerciseTwoActivity
import com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.finalexercise.OnboardingActivity
import com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.homework.RegisterActivityEMPV

class MainEMPVActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_empvactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnActOne = findViewById<Button>(R.id.btnActivityOneEMPV)
        val btnActTwo = findViewById<Button>(R.id.btnActivityTwoEMPV)
        val btnHomework = findViewById<Button>(R.id.btnHomeworkEMPV)
        val btnFinalExercise = findViewById<Button>(R.id.btnFinalExerciseEMPV)
        val btnBackEMPV = findViewById<Button>(R.id.btnExitEMPV)

        val clickListener = View.OnClickListener {
            when(it.id) {
                R.id.btnActivityOneEMPV -> {
                    val intent = Intent( this, InitialActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnActivityTwoEMPV -> {
                    val intent = Intent( this, HomeExerciseTwoActivity::class.java)
                    startActivity(intent)
                }
                R.id.btnHomeworkEMPV -> {
                    val intent = Intent( this, RegisterActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnFinalExerciseEMPV -> {
                    val intent = Intent( this, OnboardingActivity::class.java)
                    startActivity(intent)
                }
                R.id.btnExitEMPV -> {
                    finish()
                }
            }
        }

        btnActOne.setOnClickListener(clickListener)
        btnActTwo.setOnClickListener(clickListener)
        btnHomework.setOnClickListener(clickListener)
        btnFinalExercise.setOnClickListener(clickListener)
        btnBackEMPV.setOnClickListener(clickListener)
    }
}