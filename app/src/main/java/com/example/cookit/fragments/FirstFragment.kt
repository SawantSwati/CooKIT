package com.example.cookit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookit.DbHelper.RecipeDBHelper
import com.example.cookit.R
import com.example.cookit.databinding.FragmentFirstBinding
import com.squareup.picasso.Picasso


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(layoutInflater)

        Picasso.get()
            .load("https://firebasestorage.googleapis.com/v0/b/cookit-2da6c.appspot.com/o/Images%2FPaleo%20and%20Gluten-Free%20Breakfast%20Pizza.jpg?alt=media&token=378f98ab-8f28-420f-a04b-a544fb27cc2a&_gl=1*kg4652*_ga*MTI3NjQ5NTA1MS4xNjg2MTE4MTA2*_ga_CW55HF8NVT*MTY4NjExODEwNi4xLjEuMTY4NjEyMjYyNC4wLjAuMA..")
            .into(binding.imgRecipeImage)

        binding.txtRecipeName.text = "Breakfast Pizza"




        return binding.root

    }

}