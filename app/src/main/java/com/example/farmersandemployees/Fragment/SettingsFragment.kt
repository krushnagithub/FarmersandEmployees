package com.example.farmersandemployees.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.farmersandemployees.R
import com.example.farmersandemployees.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {
   private lateinit var binding:FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSettingsBinding.bind(inflater.inflate(R.layout.fragment_settings,null))
        val places = listOf("Select Place Id (Combo Box)", "Place 1", "Place 2", "Place 3")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, places)
        binding.placeSpinner.adapter = adapter
        binding.saveButton.setOnClickListener {
            Toast.makeText(context, "Saved!", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }
        }

