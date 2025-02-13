package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.ejercicio2.RecyclerView

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.desswapp.module4eqp2.R

class RecyclerViewActivityEMPV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_empv)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val btnExit = findViewById<Button>(R.id.btnRVEMPVMain)

        btnExit.setOnClickListener{
            finish()
        }

        val perfiles = listOf(
            PersonEntity("Juan Pérez", "Desarrollador Android"),
            PersonEntity("María Gómez", "Diseñadora UI/UX"),
            PersonEntity("Carlos López", "Gerente de Proyectos"),
            PersonEntity("Ana Torres", "Especialista en Marketing")
        )

        recyclerView.adapter = PersonAdapter(perfiles)
        recyclerView.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.VERTICAL, true)
    }
}