package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.finalexercise

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.databinding.ActivityFinalExerciseHomeBinding

class FinalExerciseHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinalExerciseHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalExerciseHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("EXTRA_USER", User::class.java)
        } else {
            intent.getSerializableExtra("EXTRA_USER") as User
        }

        binding.tvHeader.text = user?.name.let {
            if (it != null) {
                getString(R.string.final_exercise_home_title, it)
            } else {
                getString(R.string.final_exercise_home_title_no_name)
            }
        }

        binding.tvEmail.text = user?.email

        binding.tvPassword.text = user?.password

        binding.tvLastName.text = user?.lastname

        binding.tvDevices.text = user?.devices.toString()

        binding.tvSingle.text = if (user?.isSingle == true) {
            getString(R.string.final_exercise_home_title_tv_single)
        } else {
            getString(R.string.final_exercise_home_title_tv_not_single)
        }
    }
}