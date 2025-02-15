package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.homework

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.RadioGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class RegisterActivityEMPV : AppCompatActivity() {

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return email.matches(emailRegex)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_empv)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<EditText>(R.id.etName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val rgGenre = findViewById<RadioGroup>(R.id.rgGenre)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btRegister = findViewById<Button>(R.id.btRegister)
        val btnBack = findViewById<Button>(R.id.btBack)

        btRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val lastname = etLastName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            val genre = when (rgGenre.checkedRadioButtonId) {
                R.id.rbMale -> "Masculino"
                R.id.rbFemale -> "Femenino"
                R.id.rbOther -> "Otro"
                else -> ""
            }

            if (name.isEmpty() || lastname.isEmpty() || !isValidEmail(email)|| genre.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_LONG).show()
            } else {
                val registrationComplete = User(name, lastname, email, genre, password)
                val intent = Intent(this, ConfirmationActivityEMPV::class.java).apply {
                    putExtra("EXTRA_USER", registrationComplete)
                }
                startActivity(intent)
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}