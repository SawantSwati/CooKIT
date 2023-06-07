package com.example.cookit.fragments


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cookit.DbHelper.RecipeDBHelper
import com.example.cookit.R
import com.example.cookit.adapters.RecipeListAdapter
import com.example.cookit.databinding.FragmentHomeBinding
import com.example.cookit.model.Recipe
import com.example.cookit.util.MyPagerAdapter


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: MyPagerAdapter
    private var currentPage = 0
    private val timerHandler = Handler()
    private lateinit var timerRunnable: Runnable

    private lateinit var recipeListAdapter: RecipeListAdapter

    private lateinit var recipeList : ArrayList<Recipe>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)



        recipeList = RecipeDBHelper(requireContext()).getAllRecipes()
        initData()
        setOnClickListener()


        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments: List<Fragment> = listOf(FirstFragment(), SecondFragment(), ThirdFragment())
        val fragmentManager: FragmentManager = childFragmentManager
        adapter = MyPagerAdapter(fragmentManager, fragments)
        binding.viewPager.adapter = adapter
    }

   private fun initData(){
       binding.rvRecipeList.layoutManager = GridLayoutManager(requireContext(),2)

       recipeListAdapter = RecipeListAdapter(recipeList,requireContext())

       binding.rvRecipeList.adapter = recipeListAdapter

       recipeListAdapter.setOnClickListener = SetOnClickListener()


   }
    private fun setOnClickListener(){

        binding.snacks.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ListFragment()).addToBackStack("").commit()
        }
        binding.BreakFast.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ListFragment()).addToBackStack("").commit()
        }
        binding.Lunch.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ListFragment()).addToBackStack("").commit()
        }
        binding.Dinner.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ListFragment()).addToBackStack("").commit()
        }
        binding.Sweets.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ListFragment()).addToBackStack("").commit()
        }
        binding.Drinks.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ListFragment()).addToBackStack("").commit()
        }
        binding.Favourite.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer,ListFragment()).addToBackStack("").commit()
        }

        binding.cardViewViewPager.setOnClickListener {

            Toast.makeText(requireContext(), " I AM Clicked ", Toast.LENGTH_SHORT).show()

            val bundle = Bundle()

            bundle.putSerializable("recipe",RecipeDBHelper(requireContext()).getRecipeByName("Masala Dosa"))

            val selectedFragment = DishDetailFragment()

            selectedFragment.arguments = bundle

            parentFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.fragmentContainer,selectedFragment).commit()

        }



    }























    override fun onResume() {
        super.onResume()
        startAutoScroll()
    }

    override fun onPause() {
        super.onPause()
        stopAutoScroll()
    }

    private fun startAutoScroll() {
        timerRunnable = Runnable {
            if (currentPage == adapter.count - 1) {
                currentPage = 0
            } else {
                currentPage++
            }
            binding.viewPager.setCurrentItem(currentPage, true)
            timerHandler.postDelayed(timerRunnable, 3000)
        }
        timerHandler.postDelayed(timerRunnable, 3000)



    }

    private fun stopAutoScroll() {
        timerHandler.removeCallbacks(timerRunnable)
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