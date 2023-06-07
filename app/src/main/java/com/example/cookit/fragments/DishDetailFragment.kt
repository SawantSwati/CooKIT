package com.example.cookit.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cookit.databinding.RecipeFragmentBinding
import com.example.cookit.model.Recipe
import com.squareup.picasso.Picasso


class DishDetailFragment : Fragment() {

    private lateinit var binding: RecipeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecipeFragmentBinding.inflate(layoutInflater)

        val recipe = arguments?.getSerializable("recipe") as? Recipe

        Picasso.get()
            .load(recipe?.imageUrl)
            .into(binding.imgRecipe)

        binding.txtCookTime.text = recipe?.cookingTime
        binding.txtRatings.text = recipe?.ratings.toString()
        binding.txtCalories.text = recipe?.calories.toString()
        binding.txtRecipeName.text = recipe?.name.toString()

        var ingredient = ""
        for ((index, i) in recipe?.ingredients!!.withIndex()) {
            ingredient =
                ingredient + (index + 1).toString() + ". " + i.name + " " + i.quantity + ", \n"
        }
        binding.txtRecipeIngredients.text = ingredient


        var procedure = ""
        for ((index, i) in recipe.procedure!!.withIndex()) {
            procedure = procedure + (index + 1).toString() + ") " + i.steps + ": " + i.procedure + ", \n"
        }
        binding.txtRecipeProcedure.text = procedure
        Log.e("procedure", procedure)

        return binding.root
    }


}