package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.ejercicio2.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desswapp.module4eqp2.R

class PersonAdapter(val perfiles: List<PersonEntity>) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNombre: TextView = view.findViewById(R.id.txtNombre)
        val txtDescripcion: TextView = view.findViewById(R.id.txtDescripcion)

        fun render(person: PersonEntity) {
            txtNombre.text = person.name
            txtDescripcion.text = person.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person_empv, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = perfiles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(perfiles[position])
    }
}