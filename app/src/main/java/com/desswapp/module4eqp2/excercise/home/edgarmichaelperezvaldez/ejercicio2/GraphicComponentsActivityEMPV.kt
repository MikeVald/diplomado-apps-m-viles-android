package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.ejercicio2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R

class GraphicComponentsActivityEMPV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_graphic_components)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtNombre = findViewById<EditText>(R.id.etNombre)
        val chkTerminos = findViewById<CheckBox>(R.id.cbTerminos)
        val radioGroup = findViewById<RadioGroup>(R.id.rgOptions)
        val spinner = findViewById<Spinner>(R.id.spDias)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val imgBtnAcceso = findViewById<ImageButton>(R.id.ibAcceso)
        val btnExitEMPV = findViewById<Button>(R.id.btnExit)

        val opciones = listOf("1 día", "2 días", "3 días")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        btnEnviar.setOnClickListener {
            val nombre = edtNombre.text.toString()
            val terminosAceptados = chkTerminos.isChecked
            val opcionSeleccionada = when (radioGroup.checkedRadioButtonId) {
                R.id.rbOp1 -> "Pelota"
                R.id.rbOp2 -> "Cuerda"
                R.id.rbOp3 -> "Disco"
                else -> "Ninguna"
            }
            val opcionSpinner = spinner.selectedItem.toString()

            Toast.makeText(
                this,
                "Nombre: $nombre\nTérminos: $terminosAceptados\nRadio: $opcionSeleccionada\nSpinner: $opcionSpinner",
                Toast.LENGTH_LONG
            ).show()
        }

        btnExitEMPV.setOnClickListener {
            finish()
        }

        imgBtnAcceso.setOnClickListener {
            Toast.makeText(this, "Agrega info sobre el dueño", Toast.LENGTH_SHORT).show()
        }
    }
}