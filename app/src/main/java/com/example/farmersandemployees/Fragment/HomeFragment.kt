package com.example.farmersandemployees.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.example.farmersandemployees.R
import com.example.farmersandemployees.databinding.FragmentHomeBinding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController



class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.bind(inflater.inflate(R.layout.fragment_home, container, false))
        setupDrawer()
        return binding.root
    }

    private fun setupDrawer() {
        val drawerLayout = binding.root.findViewById<DrawerLayout>(R.id.drawer_layout)

        if (drawerLayout == null) {
            Log.e("HomeFragment", "DrawerLayout is null")
            return
        }

        val navController = findNavController()
        val toggle = ActionBarDrawerToggle(requireActivity(), drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.imageButton.setOnClickListener {
            Log.d("HomeFragment", "Corner button clicked")
            if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.openDrawer(GravityCompat.START)
            } else {
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.MyHistoryFragment -> {
                    navController.navigate(R.id.MyHistoryFragment)
                }
                R.id.VisitorLogsFragment -> {
                    navController.navigate(R.id.VisitorLogsFragment)
                }
                R.id.SettingsFragment -> {
                    navController.navigate(R.id.SettingsFragment)
                }
            }
            true
        }
    }
}
