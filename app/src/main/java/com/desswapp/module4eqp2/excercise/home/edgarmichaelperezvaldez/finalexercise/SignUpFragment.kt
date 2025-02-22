package com.desswapp.module4eqp2.excercise.home.edgarmichaelperezvaldez.finalexercise

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.desswapp.module4eqp2.R
import com.desswapp.module4eqp2.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private var userData: User? = null
    private lateinit var name: String
    private lateinit var lastname: String
    private lateinit var email: String
    private lateinit var password: String
    private var isSingle: Boolean = false
    private var devices: Int = 0;

    fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
        return email.matches(emailRegex)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            userData = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable("USER_DATA", User::class.java)
            } else {
                it.getSerializable("USER_DATA") as User
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userData?.let { user ->
            if (!user.email.isNullOrEmpty()) {
                println(user.email)
                binding.etSignInEmail.setText(user.email)

            }
        }

        binding.cbSignInSingle.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                isSingle = true
            } else {
                isSingle = false
            }
        }

        val data = arrayListOf( 1, 2, 3, 4, 5)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.spAge.adapter = adapter

        binding.btnSignIn.setOnClickListener {
            name = binding.etSignInName.text.toString()
            lastname = binding.etSignInLastname.text.toString()
            email = binding.etSignInEmail.text.toString()
            password = binding.etSignInPassword.text.toString()
            devices = binding.spAge.selectedItem as? Int ?: 0

            if (name.isEmpty()) {
                binding.etSignInName.error = "@string/sign_up_error_name"
            }
            if (lastname.isEmpty()) {
                binding.etSignInLastname.error = "@string/sign_up_error_lastname"
            }
            if (email.isEmpty() || !isValidEmail(email)) {
                binding.etSignInEmail.error = "@string/sign_up_error_email"
            }
            if (password.isEmpty()) {
                binding.etSignInPassword.error = "@string/sign_up_error_password"
            }
            if ( email.isNotEmpty() && password.isNotEmpty() && isValidEmail(email)) {
                val intent = Intent(requireContext(), FinalExerciseHomeActivity::class.java).apply {
                    putExtra("EXTRA_USER", User(name, lastname, email, isSingle, devices, password))
                }
                startActivity(intent)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance( userData : User) = SignUpFragment().apply {
            arguments = Bundle().apply {
                putSerializable("USER_DATA", userData)
            }
        }
    }
}