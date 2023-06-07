package com.example.cookit.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cookit.R
import com.example.cookit.model.Recipe
import com.squareup.picasso.Picasso

class RecipeListAdapter(val recipeList: ArrayList<Recipe>,val requireContext: Context) : RecyclerView.Adapter<RecipeListAdapter.RecipeHolder>(){


    interface SetOnClickListener{
        fun setOnClick(position: Int)
    }

    var setOnClickListener: SetOnClickListener? = null

    fun setOnClickListener(listener: SetOnClickListener) {
        setOnClickListener = listener
    }

    inner class RecipeHolder(private val view : View): RecyclerView.ViewHolder(view){
        var imgRecipeImage = view.findViewById<ImageView>(R.id.imgRecipeImage)

        var txtRecipeName = view.findViewById<TextView>(R.id.txtRecipeName)

        init {
            view.setOnClickListener {
                setOnClickListener?.setOnClick(adapterPosition)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_view,parent,false)

       return RecipeHolder(view)
    }

    override fun getItemCount() = recipeList.size

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {

        val data = recipeList[position]

        holder.txtRecipeName.setText( data.name.toString())

        Picasso.get()
            .load(data.imageUrl)
            .into(holder.imgRecipeImage)

        Log.e("error","${data.imageUrl}")

    }
}