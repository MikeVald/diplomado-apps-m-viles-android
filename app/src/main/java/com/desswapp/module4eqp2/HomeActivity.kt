package com.desswapp.module4eqp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.InitialActivityEMPV
import com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.MainEMPVActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnMember1 = findViewById<Button>(R.id.btnMember1)

        val btnExit = findViewById<Button>(R.id.btnExit)

        btnMember1.setOnClickListener { // Olvera Meza Allison Montserrat
            val intent = Intent( this, MainEMPVActivity::class.java)
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            finish()
        }

    }
}