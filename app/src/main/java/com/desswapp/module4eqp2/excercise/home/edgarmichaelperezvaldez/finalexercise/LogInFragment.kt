package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.finalexercise

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.databinding.FragmentLogInBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LogInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LogInFragment : Fragment() {

    private lateinit var binding : FragmentLogInBinding

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return email.matches(emailRegex)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogIn.setOnClickListener {
            val email = binding.etLogInEmail.text.toString()
            val password = binding.etLogInPassword.text.toString()

            if (email.isEmpty() || !isValidEmail(email)) {
                binding.etLogInEmail.error = "@string/log_in_error_email"
            }
            if (password.isEmpty()) {
                binding.etLogInPassword.error = "@string/log_in_error_password"
            }
            if ( email.isNotEmpty() && password.isNotEmpty() && isValidEmail(email)) {
                val intent = Intent(requireContext(), FinalExerciseHomeActivity::class.java).apply {
                    putExtra("EXTRA_USER", User("", "", email, false, 0, password))
                }
                startActivity(intent)
            }
        }

        binding.tvGoSignIn.setOnClickListener {
            val email = binding.etLogInEmail.text.toString()
            val password = binding.etLogInPassword.text.toString()
            parentFragmentManager.beginTransaction()
                .replace(R.id.LoginSignUp, SignUpFragment.newInstance(User("", "", email, false, 0, password)))
                .addToBackStack("SignUpFragment")
                .commit()

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}