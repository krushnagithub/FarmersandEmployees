package com.example.farmersandemployees.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmersandemployees.R
import com.example.farmersandemployees.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentSignUpBinding.bind(inflater.inflate(R.layout.fragment_sign_up,null))
        setUpListners()
        return binding.root
    }
    private fun setUpListners(){
        binding.btnSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_HomeFragment)
        }
        binding.txtSignIn.setOnClickListener{
            findNavController().navigate(R.id.action_signUpFragment_to_signInFragment)
        }
    }
}