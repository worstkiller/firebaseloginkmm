package com.vikas.firebaseloginkmm.androidApp.ui.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vikas.firebaseloginkmm.androidApp.R
import com.vikas.firebaseloginkmm.androidApp.databinding.FragmentSignupBinding
import com.vikas.firebaseloginkmm.shared.repository.FirebaseAuthRepository

/**
 * signup fragment for registering the user
 */
class SignUpFragment : Fragment() {

    lateinit var binding: FragmentSignupBinding
    lateinit var firebaseAuthRepository: FirebaseAuthRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSignupBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModels()
        setUpClickListeners()
    }

    private fun setUpViewModels() {
        firebaseAuthRepository = FirebaseAuthRepository()
    }

    private fun setUpClickListeners() {
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_homeFragment)
        }
    }

}