package com.example.cookit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookit.DbHelper.RecipeDBHelper
import com.example.cookit.R
import com.example.cookit.databinding.FragmentFirstBinding
import com.example.cookit.databinding.FragmentSecondBinding
import com.squareup.picasso.Picasso


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(layoutInflater)

        Picasso.get()
            .load("https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2FidliBatter.jpg?alt=media&token=59ce6de9-a32d-47b9-8f80-a9e3673b5b35")
            .into(binding.imgRecipeImage)

        binding.txtRecipeName.text = "Butter Idli"





        return binding.root

    }


}