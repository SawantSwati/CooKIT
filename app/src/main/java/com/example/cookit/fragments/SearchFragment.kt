package com.example.cookit.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cookit.DbHelper.RecipeDBHelper
import com.example.cookit.R
import com.example.cookit.adapters.RecipeListAdapter
import com.example.cookit.databinding.FragmentSearchBinding
import com.example.cookit.databinding.ListFragmentBinding
import com.example.cookit.model.Recipe

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    private lateinit var recipeListAdapter: RecipeListAdapter

    private  var recipeList = ArrayList<Recipe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater)

        binding = FragmentSearchBinding.inflate(layoutInflater)

        recipeList = RecipeDBHelper(requireContext()).getAllRecipes()

        setOnClickListener()


        return binding.root
    }


    private fun initData(){





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

    private fun setOnClickListener() {

        binding.listRecyclerview.layoutManager = GridLayoutManager(requireContext(),2)
        recipeListAdapter = RecipeListAdapter(recipeList,requireContext())
        binding.listRecyclerview.adapter = recipeListAdapter


        recipeListAdapter.setOnClickListener = SetOnClickListener()
        binding.edtSearchRecipe.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed in this case
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val query = s.toString()
                val recipeList2 =  RecipeDBHelper(requireContext()).searchRecipes(query)

                recipeList.clear()

                recipeList.addAll(recipeList2)



                recipeListAdapter.notifyDataSetChanged()



            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }


}