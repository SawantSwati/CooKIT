package com.example.cookit.model

import java.io.Serializable

data class Recipe(
    val name: String,
    val isVegetarian: Boolean,
    val cookingTime: String,
    val calories: Int,
    val difficulty: String,
    val ratings: Float,
    val ingredients: List<Ingredient>,
    val procedure: List<Procedure>,
    val imageUrl: String,

) : Serializable


data class Ingredient(
    val name: String,
    val quantity: String
)

data class Procedure(
    val steps: String,
    val procedure: String
)
