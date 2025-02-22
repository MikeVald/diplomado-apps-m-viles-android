package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.finalexercise

import java.io.Serializable

data class User(
    val name: String,
    val lastname: String,
    val email: String,
    val isSingle: Boolean,
    val devices: Int,
    val password: String
) : Serializable
