package com.example.cookit.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.cookit.fragments.FirstFragment
import com.example.cookit.fragments.SecondFragment
import com.example.cookit.fragments.ThirdFragment

class MyPagerAdapter(fm: FragmentManager, fragments: List<Fragment>) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val fragments = listOf(FirstFragment(), SecondFragment(), ThirdFragment())

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}
