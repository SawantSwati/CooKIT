package com.example.cookit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar

import com.example.cookit.R
import com.example.cookit.databinding.ActivityMainBinding
import com.example.cookit.fragments.HomeFragment
import com.example.cookit.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, HomeFragment())
            .commit()

        val toolbar = findViewById<Toolbar>(R.id.toolBar)

        val search = toolbar.findViewById<ImageView>(R.id.ab_Search)

        search.setOnClickListener {
            val fragmentContainerId = R.id.fragmentContainer
            val currentFragment = supportFragmentManager.findFragmentById(fragmentContainerId)

            if (currentFragment is SearchFragment) {
                // If SearchFragment is already open, do nothing or handle as needed
                return@setOnClickListener
            }

            val searchFragment = SearchFragment()

            if (currentFragment is HomeFragment) {
                // If HomeFragment is currently open, replace it with SearchFragment
                supportFragmentManager.beginTransaction()
                    .replace(fragmentContainerId, searchFragment)
                    .addToBackStack(null)
                    .commit()
            } else {
                // If any other fragment is currently open, simply replace it with SearchFragment
                supportFragmentManager.beginTransaction()
                    .replace(fragmentContainerId, searchFragment)
                    .commit()
            }
        }
    }
}
