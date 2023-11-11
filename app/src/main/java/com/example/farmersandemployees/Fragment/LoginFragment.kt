package com.example.farmersandemployees.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.farmersandemployees.R
import com.example.farmersandemployees.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentLoginBinding.bind(inflater.inflate(R.layout.fragment_login,null))
        setUpListners()
        return binding.root
    }
    private fun setUpListners(){
        binding.txtSignup.setOnClickListener{
            findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        binding.btnSignIN.setOnClickListener{
            findNavController().navigate(R.id.action_signInFragment_to_HomeFragment)
        }
    }

}