package com.example.cookit.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookit.DbHelper.RecipeDBHelper
import com.example.cookit.R
import com.example.cookit.databinding.FragmentFirstBinding
import com.example.cookit.databinding.FragmentThirdBinding
import com.squareup.picasso.Picasso


class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBinding.inflate(layoutInflater)

        Picasso.get()
            .load("https://firebasestorage.googleapis.com/v0/b/moviematch-39d8e.appspot.com/o/cookIt%2Fpista-badam-barfi.jpeg?alt=media&token=7b76a73f-99d4-469f-ade3-1c8263acdbbf")
            .into(binding.imgRecipeImage)

        binding.txtRecipeName.text = "Pista Burfi"






        return binding.root
    }

}