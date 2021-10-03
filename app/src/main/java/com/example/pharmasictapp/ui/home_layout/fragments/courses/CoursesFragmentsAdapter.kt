package com.example.pharmasictapp.ui.home_layout.fragments.courses

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter

class CoursesFragmentsAdapter(fragmentManager:FragmentManager) : FragmentPagerAdapter(
    fragmentManager
) {
    var fragmentList:MutableList<Fragment> = mutableListOf()
    var fragmentTitles:MutableList<String> = mutableListOf()

    override fun getCount(): Int {
       return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitles[position]
    }

    fun addFragment(fragment:Fragment,title:String){
        fragmentList.add(fragment)
        fragmentTitles.add(title)
    }

}