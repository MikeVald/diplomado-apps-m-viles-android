package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.homework

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class ConfirmationActivityEMPV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation_empv)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_USER", User::class.java)
        } else {
            intent.getSerializableExtra("EXTRA_USER") as User
        }

        val tvFullname = findViewById<TextView>(R.id.tvFullname)
        val tvMail = findViewById<TextView>(R.id.tvMail)
        val tvGenre = findViewById<TextView>(R.id.tvGenre)
        val btEdit = findViewById<Button>(R.id.btnEdit)
        val btConfirm = findViewById<Button>(R.id.btnConfirm)

        tvFullname.text = "${user?.name} ${user?.lastname}"
        tvMail.text = user?.email
        tvGenre.text = user?.genre

        btEdit.setOnClickListener {
            finish()
        }

        btConfirm.setOnClickListener {
            Toast.makeText(this, "Registro Confirmado", Toast.LENGTH_LONG).show()
        }
    }
}