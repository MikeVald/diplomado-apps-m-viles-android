package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.ejercicio2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.ejercicio2.RecyclerView.RecyclerViewActivityEMPV

class HomeExerciseTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_exercise_two)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFL = findViewById<Button>(R.id.btnFLEMPV)
        val btnLL = findViewById<Button>(R.id.btnLLEMPV)
        val btnRL = findViewById<Button>(R.id.btnRLEMPV)
        val btnCL = findViewById<Button>(R.id.btnCLEMPV)
        val btnCG = findViewById<Button>(R.id.btnGCEMPV)
        val btnRV = findViewById<Button>(R.id.btnRVEMPV)
        val btnExitEMPVArea = findViewById<Button>(R.id.btnExitEMPV)

        val clickListener = View.OnClickListener {
            when(it.id) {
                R.id.btnFLEMPV -> {
                    val intent = Intent( this, FrameLayoutActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnLLEMPV -> {
                    val intent = Intent( this, LinearLayoutActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnRLEMPV -> {
                    val intent = Intent( this, RelativeLayoutActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnCLEMPV -> {
                    val intent = Intent( this, ConstraintLayoutActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnGCEMPV -> {
                    val intent = Intent( this, GraphicComponentsActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnRVEMPV -> {
                    val intent = Intent( this, RecyclerViewActivityEMPV::class.java)
                    startActivity(intent)
                }
                R.id.btnExitEMPV -> {
                    finish()
                }
            }
        }

        btnFL.setOnClickListener(clickListener)
        btnLL.setOnClickListener(clickListener)
        btnRL.setOnClickListener(clickListener)
        btnCL.setOnClickListener(clickListener)
        btnCG.setOnClickListener(clickListener)
        btnRV.setOnClickListener(clickListener)
        btnExitEMPVArea.setOnClickListener(clickListener)
    }
}