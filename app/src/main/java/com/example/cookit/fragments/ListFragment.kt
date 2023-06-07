package com.example.cookit.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cookit.DbHelper.RecipeDBHelper
import com.example.cookit.R
import com.example.cookit.adapters.RecipeListAdapter
import com.example.cookit.databinding.ListFragmentBinding
import com.example.cookit.model.Recipe
import com.example.cookit.util.MyPagerAdapter

class ListFragment:Fragment() {

    private lateinit var binding:ListFragmentBinding

    private lateinit var recipeListAdapter: RecipeListAdapter

    private lateinit var recipeList : ArrayList<Recipe>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = ListFragmentBinding.inflate(layoutInflater)

        recipeList = RecipeDBHelper(requireContext()).getAllRecipes()

        initData()

        return binding.root
    }

    private fun initData(){

        binding.listRecyclerview.layoutManager = GridLayoutManager(requireContext(),2)

        recipeListAdapter =  RecipeListAdapter(recipeList,requireContext())

        binding.listRecyclerview.adapter = recipeListAdapter

        recipeListAdapter.setOnClickListener = SetOnClickListener()

    }



    inner class SetOnClickListener: RecipeListAdapter.SetOnClickListener{

        override fun setOnClick(position: Int) {

            val bundle = Bundle()

            bundle.putSerializable("recipe",recipeList[position])

            val dishDetailFragment = DishDetailFragment()

            dishDetailFragment.arguments = bundle

            parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragmentContainer,dishDetailFragment).commit()

        }

    }

}